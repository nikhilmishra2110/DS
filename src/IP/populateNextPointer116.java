/*
package IP;

public class populateNextPointer116 {
    public static void main(String[] args) {
    }



    public Node connect(Node root) {
            if (root == null) return root;
            Node levelNode = root;
            while (levelNode.left != null) {
                Node temp = levelNode;
                while (temp != null) {
                    temp.left.next = temp.right;
                    if (temp.next != null) {
                        temp.right.next = temp.next.left;
                    }
                    temp = temp.next;
                }
                levelNode = levelNode.left;
            }
            return root;
        }
    }
*/
