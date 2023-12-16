package Week9_Tree;

import java.util.Scanner;

public class PreorderTraversal{
    public static void preOrder(Node root){
        if (root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
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
        preOrder(root);
    }
}
