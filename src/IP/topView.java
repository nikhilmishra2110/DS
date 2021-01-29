package IP;

    // Java program to print top
// view of binary tree
import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
    // class to create a node
    class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }
        private void TopView(Node root) {
            class Pair {
                Node node;
                int distance;
                Pair(Node node, int distance) {
                    this.node = node;
                    this.distance = distance;
                }
            }
            Queue<Pair> q = new LinkedList<Pair>();
            Map<Integer, Node> hm = new TreeMap<Integer, Node>();
            if (root == null) {
                return;
            } else {
                q.add(new Pair(root, 0));
            }
            while (!q.isEmpty()) {
                Pair rem = q.poll();
                if (!hm.containsKey(rem.distance)) {
                    hm.put(rem.distance, rem.node);
                }
                if (rem.node.left != null) {
                    q.add(new Pair(rem.node.left, rem.distance - 1));
                }
                if (rem.node.right != null) {
                    q.add(new Pair(rem.node.right, rem.distance + 1));
                }
            }
            for (Entry<Integer, Node> entry : hm.entrySet()) {
                System.out.print(entry.getValue().data + " ");
            }
        }

        // Driver Program to test above functions
        public static void main(String[] args)
        {
		/* Create following Binary Tree
			1
		/ \
		2 3
		\
			4
			\
			5
			\
				6*/
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.right = new Node(4);
            tree.root.left.right.right = new Node(5);
            tree.root.left.right.right.right = new Node(6);
            System.out.println("Following are nodes in top view of Binary Tree");
            tree.TopView(tree.root);
        }

    }



