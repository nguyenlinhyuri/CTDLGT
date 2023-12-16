package Week10_BinarySearchTree;

import Week10_BinarySearchTree.TreeNode;
import com.sun.source.tree.Tree;

/**
 * Cây AVL là cây nhị phân tìm kiếm cân bằng với “chiều cao” giữa cây con bên trái và cây con bên phải
 * chênh nhau không vượt quá 1
 */
public class AVLTree {
    // lấy chiều cao của cây
    public int getHeight(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * Cây lệch
     * - trái trái -> xoay phải
     * - trái phải -> xoay trái -> xoay phải
     * - phải phải -> xoay trái
     * - phải trái -> xoay phải -> xoay trái
     */



    // cây bị lệch trái -> quay phải
    public TreeNode rightRotate(TreeNode root) {
        TreeNode x = root.left;

        root.left = x.right;
        x.right = root;

        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        x.ht = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    // cây bị lệch phải -> quay trái
    public TreeNode leftRotate(TreeNode root){
        TreeNode y = root.right;

        root.right = y.left;
        y.left = root;

        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        y.ht = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }


}
