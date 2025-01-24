package graph.adjacency_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return end + " " + weight;
        }
    }

    static class Graph {
        private List<List<Node>> adjList;

        public Graph(int numOfVertices) {
            adjList = new ArrayList<>();
            for (int i = 0; i <= numOfVertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int from, int to, int weight) {
            adjList.get(from).add(new Node(to, weight));
            Collections.sort(adjList.get(from), (o1, o2) -> o1.end - o2.end);
        }

        public void removeEdge(int from, int to) {
            List<Node> edges = adjList.get(from);
            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).end == to) {
                    edges.remove(i);
                    break;
                }
            }
        }

        public void modifyEdge(int from, int to, int weight) {
            if (from >= adjList.size() || to >= adjList.size() || from <= 0 || to <= 0) {
                System.out.println(-1);
                return;
            }

            boolean edgeFromTo = false;
            boolean edgeToFrom = false;

            List<Node> edgesFrom = adjList.get(from);
            for (Node edge : edgesFrom) {
                if (edge.end == to) {
                    edgeFromTo = true;
                    if (weight == 0) {
                        removeEdge(from, to);
                    } else {
                        edge.weight = weight;
                    }
                    break;
                }
            }

            List<Node> edgesTo = adjList.get(to);
            for (Node edge : edgesTo) {
                if (edge.end == from) {
                    edgeToFrom = true;
                    if (weight == 0) {
                        removeEdge(to, from);
                    } else {
                        edge.weight = weight;
                    }
                    break;
                }
            }

            if (!edgeFromTo && !edgeToFrom) {
                if (weight == 0) {
                    System.out.println(-1);
                } else {
                    addEdge(from, to, weight);
                    addEdge(to, from, weight);
                }
            }

            Collections.sort(adjList.get(from), (o1, o2) -> o1.end - o2.end);
            Collections.sort(adjList.get(to), (o1, o2) -> o1.end - o2.end);
        }

        public void printEdge(int from) {
            if (from >= adjList.size() || from <= 0) {
                System.out.println(-1);
                return;
            }
            List<Node> edges = adjList.get(from);

            for (Node edge : edges) {
                System.out.print(" " + edge);
            }
            System.out.println();
        }
    }

    static void graphInit(Graph graph) {
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(1, 6, 2);

        graph.addEdge(2, 1, 1);
        graph.addEdge(2, 3, 1);

        graph.addEdge(3, 1, 1);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 4);

        graph.addEdge(4, 1, 1);

        graph.addEdge(5, 3, 4);
        graph.addEdge(5, 5, 4);
        graph.addEdge(5, 6, 3);

        graph.addEdge(6, 1, 2);
        graph.addEdge(6, 5, 3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Graph graph = new Graph(6);
        graphInit(graph);

        while (true) {
            String command = scanner.next();
            if (command.equals("q")) break;

            switch (command) {
                case "a":
                    int node = scanner.nextInt();
                    graph.printEdge(node);
                    break;
                case "m":
                    int from = scanner.nextInt();
                    int to = scanner.nextInt();
                    int weight = scanner.nextInt();
                    graph.modifyEdge(from, to, weight);
            }
        }
    }
}