package Week10_BinarySearchTree;

import java.util.Scanner;

public class IsThisABST {
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

//    public static void preOrder(TreeNode root){
//        if (root == null) return;
//        System.out.print(root.val + " ");
//        preOrder(root.left);
//        preOrder(root.right);
//    }

    public static boolean isBST(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val < min || node.val > max) return false;
        return isBST(node.left, min, node.val - 1) && isBST(node.right, node.val + 1, max);
    }

    public static boolean checkBST(TreeNode root) {
        return isBST(root, 0, 100000);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;
        while (n-- > 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        System.out.println(checkBST(root));
    }

}
