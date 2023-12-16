package Week9_Tree;

import java.util.*;

public class LevelorderTraversal {
    public static void levelOrder(Node root){
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();

            for (int i=0; i<queue.size(); i++){
                Node node = queue.poll();
                System.out.print(node.val + " ");

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }

    public static Node insert(Node root, int data){
        if (root == null){
            return new Node(data);
        } else {
            Node current;
            if (data <= root.val){
                current = insert(root.left, data);
                root.left = current;
            } else {
                current = insert(root.right, data);
                root.right = current;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Node root = null;
        while(t-- > 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        sc.close();
        levelOrder(root);
    }
}