//package IP;
//// Definition for a Node.
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//};
//
// class PopulateNextPointerBSTpublic {
//    public void connect(Node root) {
//        Node level_start=root;
//        while(level_start!=null){
//            Node temp=level_start;
//            while(temp!=null){
//                if(temp.left!=null) temp.left.next=temp.right;
//                if(temp.right!=null && temp.next!=null) temp.right.next=temp.next.left;
//
//                temp=temp.next;
//            }
//            level_start=level_start.left;
//        }
//    }
//}
//}
