package BST;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {

    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            TreeNode newNode = new TreeNode(value);
            return newNode;
        } else if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }
//
//    public TreeNode delete(TreeNode node, int value){
//        if(node ==null){
//            return null;
//        }
//        if(value < node.data){
//            node.left = delete(node.left, value);
//        } else if (value > node.data){
//            node.right = delete(node.right, value);
//        }else{// node to be deleted
//            if(node.left == null || node.right == null){
//                TreeNode temp = null;
//                temp = node.left == null? node.right: node.left;
//                if(temp ==null){ //both null
//                    return null;
//                } else{
//                    return node;
//                }
//            } else {
//
//            }
//        }
//
//    }





}

public class BSTApp {
    public static void main(String[] args) {
        BST a = new BST();
        TreeNode root = null;
        root = a.insert(root, 8);
        root = a.insert(root, 3);
        root = a.insert(root, 6);
        root = a.insert(root, 10);
        root = a.insert(root, 4);
        root = a.insert(root, 7);
        root = a.insert(root, 1);
        root = a.insert(root, 14);
        root = a.insert(root, 13);


    }


}
