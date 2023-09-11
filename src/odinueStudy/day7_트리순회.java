package odinueStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    String data;
    Node left;
    Node right;

    Node(String data) {
        this.data = data;
    }
}
public class day7_트리순회 {
    static Node root;
    public static void main(String[] args) throws IOException {
        day7_트리순회 d = new day7_트리순회();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String data = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

//            System.out.println(data);
//            System.out.println(left);
//            System.out.println(right);
//            System.out.println("---------------------");

            createNode(data, left, right);
        }

        preOrder(d.root);


    }

    public static void createNode(String data, String left, String right) {
        if (root == null) { // root가 null이면 초기상태
            root = new Node(data);

            //좌우 값이 있는 경우 ( . 또는 -1이 아닌 경우)
            if (left != ".") {
                root.left = new Node(left);
            }
            if (right != ".") {
                root.right = new Node(right);
            }

        } else {    // 초기 상태가 아니라면 root 노드 생성 이후 만들어진 노드 중 어떤건지 찾아야함.
            searchNode(root, data, left, right);
        }
    }

    private static void searchNode(Node node, String data, String left, String right) {
        if (node == null) {     //도착한 노드가 null이면 재귀 종료 - 찾을 노드 X
            return;
        } else if (node.data == data) {     // 들어갈 노드, 일치하는 노드가 있다면
            if (left != ".") {
                node.left = new Node(left);
            }
            if (right != ".") {
                node.right = new Node(right);
            }
        } else {     // 아직 찾지 못했고, 탐색할 노드가 남아있다면
            searchNode(node.left, data, left, right);   // 왼쪽 노드 재귀탐색
            searchNode(node.right, data, left, right);  // 오른쪽 노드 재귀탐색

        }
    }


    private static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.left != null) {
                preOrder(node.left);
            }
            if (node.right != null) {
                preOrder(node.right);
            }

        }
    }

    private static void inOrder(Node node) {
        if (node != null) {
            if (node.left != null) {
                inOrder(node.left);
            }
            System.out.println(node.data);
            if (node.right != null) {
                inOrder(node.right);
            }
        }
    }

    private static void postOrder(Node node) {
        if (node != null) {
            if (node.left != null) {
                postOrder(node.left);
            }
            if (node.right != null) {
                postOrder(node.right);
            }
            System.out.println(node.data);
        }
    }


}
