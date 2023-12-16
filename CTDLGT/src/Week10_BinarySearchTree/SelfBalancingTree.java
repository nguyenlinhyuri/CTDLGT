package Week10_BinarySearchTree;

public class SelfBalancingTree {
    public static int getHeight(TreeNode root) {
        return root == null ? -1 : root.ht;
    }
    public static void update_height(TreeNode root) {
        root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    public static TreeNode rotateRight(TreeNode root) {
        TreeNode temp = root.left;
        root.left = temp.right;
        temp.right = root;

        update_height(root);
        update_height(temp);
        return temp;
    }
    public static TreeNode rotateLeft(TreeNode root) {
        TreeNode temp = root.right;
        root.right = temp.left;
        temp.left = root;

        update_height(root);
        update_height(temp);
        return temp;
    }
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        } else if (value < root.val) {
            root.left = insert(root.left, value);
            if (getHeight(root.left) - getHeight(root.right) == 2) {
                if (value > root.left.val) {
                    root.left = rotateLeft(root.left);
                }
                root = rotateRight(root);
            }
        } else {
            root.right = insert(root.right, value);
            if (getHeight(root.right) - getHeight(root.left) == 2) {
                if (value < root.right.val) {
                    root.right = rotateRight(root.right);
                }
                root = rotateLeft(root);
            }
        }
        update_height(root);
        return root;
    }
    public static void main(String[] args) {
    }
}
