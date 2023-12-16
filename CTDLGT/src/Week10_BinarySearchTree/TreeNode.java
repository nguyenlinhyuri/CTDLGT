package Week10_BinarySearchTree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public int ht;

    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * cây nhị phân | mỗi node cha có <= 2 node con
 * cây nhị phân tìm kiếm | các node trái luôn < node cha, các node phái luôn > node cha, các cây con cũng thỏa mãn tính chất trên
 * cây nhị phân cân bằng (AVL) | tại mỗi nút, độ cao của cây con trái và phải không lệch nhau quá 1 đơn vị
 *
 */
