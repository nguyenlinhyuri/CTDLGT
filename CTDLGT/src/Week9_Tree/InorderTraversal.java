package Week9_Tree;

import java.util.*;

public class InorderTraversal {
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        Node cur;
        if (data <= root.val) {
            cur = insert(root.left, data);
            root.left = cur;
        } else {
            cur = insert(root.right, data);
            root.right = cur;
        }
        return root;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        while (n-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        inOrder(root);
    }
}
