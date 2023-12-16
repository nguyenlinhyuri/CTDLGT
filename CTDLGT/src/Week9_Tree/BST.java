package Week9_Tree;

public class BST {
    private Node myRoot;

    // thêm node - dùng vòng lặp--------------------------------
    public Node insertNode1(Node root, int value){
        if (root == null){
            return new Node(value);
        } else {
            Node temp = root;
            while (true){
                if (temp.val < value){
                    if (temp.right == null) {
                        temp.right = new Node(value);
                        break;
                    }
                    else temp = temp.right;
                } else {
                    if (temp.left == null) {
                        temp.left = new Node(value);
                        break;
                    }
                    else temp = temp.left;
                }
            }
            return root;
        }
    }

    // thêm node - dùng đệ quy --------------------------------
    public Node insertNode2(Node root, int value){
        if (root == null) return new Node(value);
        if (root.val > value){
            if (root.left == null) root.left = new Node(value);
            else insertNode2(root.left, value);
        } else {
            if (root.right == null) root.right = new Node(value);
            else insertNode2(root.right, value);
        }
        return root;
    }

    // xóa node - trả về cây mới đã xóa node key -----------------
    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                // Nút cần xóa không có con
                return null;
            } else if (root.left != null && root.right == null) {
                // Nút cần xóa chỉ có con trái
                return root.left;
            } else if (root.left == null && root.right != null) {
                // Nút cần xóa chỉ có con phải
                return root.right;
            } else {
                // Nút cần xóa có cả con trái và con phải
                Node leftNode = findLeftMost(root.right);
                root.val = leftNode.val;
                root.right = deleteNode(root.right, leftNode.val);
            }
        }
        return root;
    }

    private Node findLeftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // tìm kiếm node----------------------------------
    public Node searchBST(Node root, int key){
        if (root == null) return null;

        if (key < root.val) return searchBST(root.left, key);
        else if (key > root.val) return searchBST(root.right, key);
        else return root;
    }

    // duyệt cây
    public void preOrder(Node root){
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
}
