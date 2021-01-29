package Tree;

import java.util.*;

public class Main {

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ". ";
        System.out.println(str);
        // above: 10 itself and its family

        // below child will print themselves and thier families
        for (Node child : node.children) {
            display(child);
        }
    }

    public static int size(Node node) {
        int s = 0;
        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;
        return s;
    }

    public static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }

    public static int maximum(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int childMax = maximum(child);
            if (childMax > max) {
                max = childMax;
            }

        }
        if (max < node.data) {
            max = node.data;
        }
        return max;
    }

    public static int heightOfGenericTree(Node node) {
        // Base case - agar ek hi node hai to edge ke terms me height zero hone chahiye
        //
        int ht = -1;

        // children me sabse bada kaun hai leke aao
        for (Node child : node.children) {
            int ch = heightOfGenericTree(child);
            ht = Math.max(ch, ht);
        }
        // sabse bade me ek add kardo

        ht += 1;
        return ht;
    }


    public static void traversals(Node node) {
        // area 1
        // euler left - node pre area, on the way to recursion
        System.out.println("Node pre " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge post " + node.data + "--" + child.data);
        }
        // euler right - node post area, on the way out of the recursion
        System.out.println("Node post " + node.data);
    }

    public static void levelOrdertraversal(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
//        int [] res = new int[];
        while (q.size() != 0) {
            node = q.remove();
            System.out.println(node.data + " ");
            for (Node child : node.children) {
                q.add(child);
            }
        }
    }

    public static void levelOrdertraversalLinewise(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        mq.add(node);
//        int [] res = new int[];
        while (mq.size() > 0) {
            node = mq.remove();
            System.out.print(node.data + " ");
            for (Node child : node.children) {
                cq.add(child);
            }
            if (mq.size() == 0) {
                System.out.println();
                mq = cq;
                cq = new ArrayDeque<>();
            }
        }
    }

    public static void levelOrderZigZag(Node node) {//TODO: revisit
        Stack<Node> ms = new Stack();
        ms.add(node);
        int level = 0;
        Stack<Node> cs = new Stack();
        while (ms.size() > 0) {
            node = ms.pop();
            System.out.print(node.data + "  ");
            if (level % 2 == 0) {
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }

            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack<>();
                System.out.println();
                level += 1;
            }

        }

    }

    public static void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    public static void removeLeaves(Node node) {
        //TODO: Concurrent modification error - jisme loop usi me modification
        /* for(Node child : node.children){
            if (child.children.size()==0){
                node.children.remove(child);
            }
        }*/

        //TODO: logical error
        /* for(int i = 0; i < node.children.size(); i++){
            Node child = node.children.get(i);
            if (child.children.size()==0){
                node.children.remove(child);
            }
            [2,9,8,6,4,5,3]
            remove 2, i= 0, arr becomes = [9,8,6,4,5,3] and i become 1 sp 9 is missed
        }*/

        /* TODO: Another logical error - post order me removal jo leaf tha bhi nahi wo leaf dikhai dega   isiliye pre order me remove karo na ki post me
            for(int i = node.children.size() -1; i >=0; i--){
            Node child = node.children.get(i);
            if (child.children.size()==0){
                node.children.remove(child);
            }
            */

        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i); //weak point need to revisit
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }
    }

    public static void linearizeTree(Node node) {
        for (Node child : node.children) {
            linearizeTree(child);
        }
        while (node.children.size() > 1) {
            Node lastChild = node.children.remove(node.children.size() - 1);
            Node secondLast = node.children.get(node.children.size() - 1);
            Node secondLastTail = getTail(secondLast);
            secondLastTail.children.add(lastChild);
        }
    }

    public static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

    public static boolean findElement(Node node, int val) {
        if (node.data == val) {
            return true;
        }
        for (Node child : node.children) {
            boolean v = findElement(child, val);
            if (v) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> findNodetoRootPath(Node node, int val) {
        if (node.data == val) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for (Node child : node.children) {
            ArrayList<Integer> pathTillChild = findNodetoRootPath(child, val);
            if (pathTillChild.size() > 0) { /* bache ke pass data hai, khud ko add karao aur laut jao */
                pathTillChild.add(node.data);
                return pathTillChild;
            }
        }
        return new ArrayList<>();
    }

    public static int lowestCommomAncestor(Node node, int val1, int val2) {
        ArrayList<Integer> path1 = findNodetoRootPath(node, val1);
        ArrayList<Integer> path2 = findNodetoRootPath(node, val2);
        int i = path1.size() - 1;
        int j = path2.size() - 1; // -1 bhoo jate hai
        System.out.println(path1);
        System.out.println(path2);
        while (i != 0 && j != 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return path1.get(i);
    }

    public static int distanceBetweenTwoNodes(Node node, int val1, int val2) {
        ArrayList<Integer> path1 = findNodetoRootPath(node, val1);
        ArrayList<Integer> path2 = findNodetoRootPath(node, val2);
        int i = path1.size() - 1;
        int j = path2.size() - 1; // -1 bhoo jate hai
        while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return i + j;
    }

    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        // yaha aya hai to matlab hai number of children same hai
        // ek loop laga ke pata laga lo ki children akun hai
        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if (areSimilar(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }


    public static boolean areMirrorImage(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        for (int i = 0; i < n1.children.size(); i++) {
            int j = n1.children.size() - 1 - i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if (areMirrorImage(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSymmetric(Node n1) {
        return areMirrorImage(n1, n1);
    }

    static Node predecessor;
    static Node successor;
    static int state;

    public static void predecessorSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {// jis din data mil gaya us din hum predecessor nahi badlenge lekin state ko badal denge
                state = 1;
            } else {
                predecessor = node; // jaha jaha pointer ja raha hai wo wo predecessor banta jaega
            }
        } else if (state == 1) { // state 1 nahi hai
            successor = node;
            state = 2;
        }
        for (Node child : node.children) {
            predecessorSuccessor(child, data);
        }
    }

    static int ceil; // smallest among larger
    static int floor; // largest among smallers

    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data) { // data se sare bade walo me
            if (node.data < ceil) {// sabse chota
                ceil = node.data;
            }
        }
        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }


    public  static int kthLargest(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for(int i = 0; i < k; i ++){
            ceilAndFloor(node,factor);// will set floor as 120..highest value
            factor  = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }


    static int maximumSumNode= 0 ;
    static int maximumSum = Integer.MIN_VALUE;
    static int retSumAndCaluculateMSST(Node node){
        int sum = 0;
        for(Node child: node.children){
            int childSum = retSumAndCaluculateMSST(child);
            sum+=childSum;
        }
        sum+=node.data;
        if (sum> maximumSum){//calculate something -- maximum
            maximumSum = sum;
            maximumSumNode = node.data;
        }
        return sum;//return something else -just sum not max - as this will help us get the max
    }


    static int diameter;
    static int calculateDiaReturnHeight(Node node){
        int deepestChildHeight = -1;
        int secondDeepestChildHeight = -1;
        for(Node child: node.children) {
            int childHeight = calculateDiaReturnHeight(child);
            if(childHeight > deepestChildHeight){
                secondDeepestChildHeight =deepestChildHeight;
                deepestChildHeight = childHeight;
            } else if (childHeight > secondDeepestChildHeight){
                secondDeepestChildHeight = childHeight;
            }
        }
        if (deepestChildHeight+secondDeepestChildHeight+2 > diameter){
            diameter = deepestChildHeight+secondDeepestChildHeight+2;
        }
        deepestChildHeight+=1;
        return deepestChildHeight;
        }



    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        int[] arr2 = {10, 20, 20, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        Node root2 = construct(arr2);
        display(root);
//        System.out.println(size(root));
//        System.out.println(maximum(root));
//        System.out.println(heightOfGenericTree(root));
//        traversals(root);
//        levelOrdertraversal(root);
//        levelOrdertraversalLinewise(root);
//        levelOrderZigZag(root);
//        mirror(root);
//        display(root);
//        removeLeaves(root);
//        System.out.println(findElement(root, 110));
//        System.out.println(findNodetoRootPath(root, 110));
//        System.out.println(lowestCommomAncestor(root, 70, 110));
//        System.out.println(distanceBetweenTwoNodes(root, 70, 110));
//        System.out.println(areSimilar(root, root2));
//        System.out.println(areMirrorImage(root, root2));

      /*
        int data = 110;
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        ceilAndFloor(root, data);
        System.out.println("Ceil = " + ceil);
        System.out.println("Floor = " + floor);
        */

        int k = 3;
//        System.out.println(kthLargest(root, k));

   /*
    System.out.println(retSumAndCaluculateMSST(root));// we are not interested in this return value
        System.out.println(maximumSumNode + " @ " +maximumSum);
*/

//    calculateDiaReturnHeight(root);
//        System.out.println(diameter);
    }


    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }


}
