package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;


public class Main {

    static ArrayList<Node> pth = new ArrayList<>();
    static ArrayList<Integer> path2 = new ArrayList<>();

    static int tilt = 0;
    public static int tilt(Node node){
        if(node == null){
            return 0;
        }
        int leftSum = tilt(node.left);
        int rightSum = tilt(node.right);

        tilt += Math.abs(leftSum - rightSum);

        int ts = leftSum + rightSum + node.data;
        return ts;
    }




    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null) {
            return;
        }

        if (parent != null && parent.left == null && parent.right == node) {
            System.out.println(node.data);
        } else if (parent != null && parent.right == null && parent.left == node) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }


    public static Node transBackFromLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }

        node.left = transBackFromLeftClonedTree(node.left.left);
        node.right = transBackFromLeftClonedTree(node.right);

        return node;
    }


    public static Node createLeftCloneTree(Node node) {
        if (node == null) {
            return null;
        }

        Node lcr = createLeftCloneTree(node.left);
        Node rcr = createLeftCloneTree(node.right);

        node.left = new Node(node.data, lcr, null);
        node.right = rcr;

        return node;
    }


    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node.left != null && node.right != null) {
            pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
            pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else if (node.left != null) {
            pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        } else if (node.right != null) {
            pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else {
            path += node.data;
            sum += node.data;

            if (sum >= lo && sum <= hi) {
                System.out.println(path);
            }
        }
    }


    public static void printKFarAway(Node node, int data, int k) {
        findReturnNode(node, data);
        System.out.println(pth);
        for (int i = 0; i < pth.size(); i++) {
            printKLevelsFarBlocker(pth.get(i), k - 1, i == 0 ? null : pth.get(i - 1));
        }


    }

    public static void printKLevelsFarBlocker(Node node, int k, Node blocker) {
        if (node == null || k < 0 || node == blocker) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
        }
        printKLevelsFarBlocker(node.left, k - 1, blocker);
        printKLevelsFarBlocker(node.right, k - 1, blocker);
    }


    public static boolean findReturnNode(Node node, int data) {
        // same as Node to Root Path
        // adha Eulre chlta hai
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            pth.add(node);
            return true;
        }

        boolean foundInLeftChild = find(node.left, data);
        if (foundInLeftChild) {
            pth.add(node);
            return true;
        }

        boolean foundInRightChild = find(node.left, data);
        if (foundInRightChild) {
            pth.add(node);
            return true;
        }

        return false;
    }


    public static void printKLevelsDown(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
        }
        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        boolean filc = find(node.left, data);
        if (filc) {
            return true;
        }

        boolean firc = find(node.right, data);
        if (firc) {
            return true;
        }

        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        ArrayList<Integer> llist = nodeToRootPath(node.left, data);
        if (llist.size() > 0) {
            llist.add(node.data);
            return llist;
        }

        ArrayList<Integer> rlist = nodeToRootPath(node.right, data);
        if (rlist.size() > 0) {
            rlist.add(node.data);
            return rlist;
        }

        return new ArrayList<>();
    }

    public static boolean findNodeToRootPathInteger(Node node, int data) {
        // same as Node to Root Path
        // adha Eulre chlta hai

        if (node == null) {
            return false;
        }

        if (node.data == data) {
            path2.add(node.data);
            return true;
        }

        boolean foundInLeftChild = find(node.left, data);
        if (foundInLeftChild) {
            path2.add(node.data);
            return true;
        }

        boolean foundInRightChild = find(node.left, data);
        if (foundInRightChild) {
            path2.add(node.data);
            return true;
        }

        return false;
    }

    public static void Iterativetraversal(Node node) {
        Stack<Pair> st = new Stack<>();
        Pair rtp = new Pair(node, 1);
        st.push(rtp);
        String pre = "";
        String in = "";
        String post = "";

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) {// pre me hai
                // state ++
                // left jaeye
                // ====> pre, S++, left
                pre += top.node.data + " ";
                top.state++;

                if (top.node.left != null) {
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
            } else if (top.state == 2) {// left hoke aaye hai state ++
                // right aje
                // ==> in, state++, right
                in += top.node.data + " ";
                top.state++;

                if (top.node.right != null) {
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
            } else {
                // left right sab kar aaye//
                // ===> post, pop
                post += top.node.data + " ";
                st.pop();
            }

        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }

    public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        // RPA
        q.add(node);

        while (q.size() > 0) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                node = q.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls + rs + node.data;
        return ts;
    }

    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int lm = max(node.left);
        int rm = max(node.right);
        int tm = Math.max(node.data, Math.max(lm, rm));
        return tm;
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    static void display(Node node) {
/*       node self work
         display left child
         display right child
         */
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? " . " : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? " . " : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);

    }

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 63, null, 70, null, null, 87, null, null};

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null); // agar non null hai to node banaye
                    Pair lp = new Pair(top.node.left, 1);// stack update ke liye
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null); // agar non null hai to node banaye
                    Pair rp = new Pair(top.node.right, 1);// stack update ke liye
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }


//        display(root);
        Node node = createLeftCloneTree(root);
        display(node);
        preOrder(node);
//        findReturnNode(root, 37);
//        System.out.println(pth);
//        printKFarAway(root, 37, 2);
//        System.out.println();
//        preOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        levelOrder(root);
//        System.out.println();
//        Iterativetraversal(root);
//        System.out.println();
//        printKLevelsDown(root, 2);
//        System.out.println();
//        printKLevelsDown(root, 3);
//        System.out.println();
//        int lo = 12;
//        int hi = 75;
//        PathtoLeaffromRoot(root, "", 0, lo, hi);
//        ArrayList<Integer> path  = nodeToRootPath(root, 70);
//        System.out.println(path);
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }


}
