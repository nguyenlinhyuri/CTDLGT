package Week10_BinarySearchTree;

import java.util.*;

public class LowestCommonAncestor {
    public static TreeNode insert(TreeNode root, int data){
        if (root == null) return new TreeNode(data);
        TreeNode cur;
        if (data < root.val){
            cur = insert(root.left, data);
            root.left = cur;
        } else {
            cur = insert(root.right, data);
            root.right = cur;
        }
        return root;
    }

    public static TreeNode lca(TreeNode root, int v1, int v2){
        if (v1 > root.val && v2 > root.val){
            return lca(root.right, v1, v2);
        }
        if (v1 < root.val && v2 < root.val){
            return lca(root.left, v1, v2);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;
        while (n-- > 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int v1 = sc.nextInt();
        int v2  =sc.nextInt();
        TreeNode ans = lca(root, v1, v2);
        System.out.println(ans.val);
    }
}