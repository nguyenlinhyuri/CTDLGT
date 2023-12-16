package Week10_BinarySearchTree;

import java.util.*;

public class Insertion {
    public static TreeNode insert(TreeNode root, int value){
        if (root == null) return new TreeNode(value);

        TreeNode cur;
        if (value < root.val){
            cur = insert(root.left, value);
            root.left = cur;
        } else {
            cur = insert(root.right, value);
            root.right = cur;
        }
        return root;
    }

    public static void preOrder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;
        while (n-- > 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        preOrder(root);
        sc.close();
    }
}