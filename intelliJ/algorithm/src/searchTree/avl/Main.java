package searchTree.avl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    static class Tree {
        Node root;

        private int getHeight(Node node) {
            return (node == null) ? 0 : node.height;
        }

        private int getBalanceFactor(Node node) {
            return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
        }

        private Node LL(Node node) {
            Node currentNode = node.left;
            Node parentNode = node;

            parentNode.left = currentNode.right;
            currentNode.right = parentNode;

            parentNode.height = Math.max(getHeight(parentNode.left), getHeight(parentNode.right)) + 1;
            currentNode.height = Math.max(getHeight(currentNode.left), getHeight(currentNode.right)) + 1;

            return currentNode;
        }

        private Node RR(Node node) {
            Node parentNode = node;
            Node currentNode = node.right;

            parentNode.right = currentNode.left;
            currentNode.left = parentNode;

            // 높이 갱신
            parentNode.height = Math.max(getHeight(parentNode.left), getHeight(parentNode.right)) + 1;
            currentNode.height = Math.max(getHeight(currentNode.left), getHeight(currentNode.right)) + 1;

            return currentNode; // 새로운 루트 반환
        }

        private Node LR(Node node) {
            Node parentNode = node;
            Node currentNode = node.left;

            // 왼쪽 자식에 RR 회전 적용 후 LL 회전
            parentNode.left = RR(currentNode);
            return LL(parentNode);
        }

        private Node RL(Node node) {
            Node parentNode = node;
            Node currentNode = node.right;

            // 오른쪽 자식에 LL 회전 적용 후 RR 회전
            parentNode.right = LL(currentNode);
            return RR(parentNode);
        }

        private Node reBalance(Node root) {
            int diff = getBalanceFactor(root);

            // LL 또는 LR
            if (diff > 1) {
                if (getBalanceFactor(root.left) >= 0) {
                    // LL
                    root = LL(root);
                } else {
                    // LR
                    root = LR(root);
                }
            }
            // RR 또는 RL
            else if (diff < -1) {
                if (getBalanceFactor(root.right) <= 0) {
                    // RR
                    root = RR(root);
                } else {
                    // RL
                    root = RL(root);
                }
            }

            return root;
        }

        public Node insert(Node node, int key) {
            if (node == null)
                return new Node(key);
            if (key < node.data) {
                node.left = insert(node.left, key);
            } else if (key > node.data) {
                node.right = insert(node.right, key);
            } else {
                return node; // 중복 키
            }

            node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

            return reBalance(node);
        }

        public Node delete(Node node, int key) {
            if (node == null)
                return node;
            if (key < node.data) {
                node.left = delete(node.left, key);
            } else if (key > node.data) {
                node.right = delete(node.right, key);
            } else {
                if (node.left == null || node.right == null) {
                    node = (node.left != null) ? node.left : node.right;
                } else {
                    Node inorderSucc = getInorderSucc(node.right);
                    node.data = inorderSucc.data;
                    node.right = delete(node.right, inorderSucc.data);
                }
            }

            if (node == null) return node;

            node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
            return reBalance(node);
        }

        private Node getInorderSucc(Node node) {
            Node currentNode = node;
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }

            return currentNode;
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
                    tree.root = tree.insert(tree.root, key);
                    break;
                }
                case "d": { // 값이 있으면 삭제 후 출력, 없으면 X 출력
                    int key = Integer.parseInt(st.nextToken());
                    if (tree.search(key) == null) {
                        System.out.println("X");
                    } else {
                        tree.root = tree.delete(tree.root, key);
                        System.out.println(key);
                    }
                    break;
                }
                case "s": { // 값이 있으면 출력, 없으면 X 출력
                    int key = Integer.parseInt(st.nextToken());
                    if (tree.search(key) == null) System.out.println("X");
                    else System.out.println(key);
                    break;
                }
                case "p":  // 트리를 전위순회로 출력
                    tree.printAll();
                    break;
                case "q":  // 종료
                    break label;
            }
        }
    }
}
