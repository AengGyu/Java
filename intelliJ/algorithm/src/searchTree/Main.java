package searchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Tree tree = new Tree();

        label:
        while (true) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "i": { // 삽입
                    int key = Integer.parseInt(st.nextToken());
                    tree.insert(key);
                    break;
                }
                case "d": { // 값이 있으면 삭제 후 출력, 없으면 X 출력
                    int key = Integer.parseInt(st.nextToken());
                    if (tree.delete(key) == null) System.out.println("X");
                    else System.out.println(key);
                    break;
                }
                case "s": { // 값이 있으면 출력, 없으면 X 출력
                    int key = Integer.parseInt(st.nextToken());
                    if (tree.search(key) == null) System.out.println("X");
                    else System.out.println(key);
                    break;
                }
                case "p":  // 트리를 중위순회로 출력
                    tree.printAll();
                    break;
                case "q":  // 종료
                    break label;
            }
        }
    }

    static class Tree {
        Node root;

        public void insert(int key) {
            Node node = new Node(key);
            Node currentNode = root;
            Node parentNode = null;

            while (currentNode != null) {
                if (currentNode.data == key) // 중복키
                    return;
                parentNode = currentNode;
                if (key < currentNode.data) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            if (parentNode == null) {
                root = node;
                return;
            }
            if (key < parentNode.data) parentNode.left = node;
            else parentNode.right = node;
        }

        public Integer delete(int key) {
            Node currentNode = root;
            Node parentNode = null;

            while (currentNode != null) {
                if (currentNode.data == key) break;
                parentNode = currentNode;
                if (key < currentNode.data)
                    currentNode = currentNode.left;
                else
                    currentNode = currentNode.right;
            }

            if (currentNode == null) return null;

            // 삭제할 노드가 자식이 없는 경우
            if (currentNode.left == null && currentNode.right == null) {
                if (currentNode == root) {
                    root = null;
                } else if (currentNode == parentNode.left) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            }
            // 삭제할 노드의 자식이 하나인 경우
            else if (currentNode.left == null || currentNode.right == null) {
                Node child = (currentNode.left == null) ? currentNode.right : currentNode.left;

                if (currentNode == root) {
                    root = child;
                } else if (currentNode == parentNode.left) {
                    parentNode.left = child;
                } else {
                    parentNode.right = child;
                }
            }
            // 삭제할 노드의 자식이 둘인 경우
            else {
                Node inOrderSuccParent = currentNode;
                Node inOrderSucc = currentNode.right;

                while (inOrderSucc.left != null) {
                    inOrderSuccParent = inOrderSucc;
                    inOrderSucc = inOrderSucc.left;
                }

                currentNode.data = inOrderSucc.data;

                if (inOrderSuccParent.left == inOrderSucc) {
                    inOrderSuccParent.left = inOrderSucc.right;
                } else {
                    inOrderSuccParent.right = inOrderSucc.right;
                }
            }


            return key;
        }

        public Integer search(int key) {
            Node currentNode = root;

            while (currentNode != null) {
                if (currentNode.data == key) return currentNode.data;

                if (key < currentNode.data) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            return null;
        }

        public void printAll() { // 중위순회로 출력
            preOrder(root);
            System.out.println();
        }

        private void preOrder(Node node) {
            if (node == null) return;

            System.out.print(" " + node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
