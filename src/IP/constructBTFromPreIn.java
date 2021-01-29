package IP;

import java.util.HashMap;
import java.util.Map;

//Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class constructBTFromPreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hm);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> hm) {
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int idx = hm.get(root.val);
        int count = idx - is;
        root.left = buildTree(preorder, ps + 1, ps + count, inorder, is, idx - 1, hm);
        root.right = buildTree(preorder, ps + count + 1, pe, inorder, idx + 1, ie, hm);
        return root;
    }



        public int maxArea(int[] height) {
            int maxarea = 0, l = 0, r = height.length - 1;
            while (l < r) {
                maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
                if (height[l] < height[r])
                    l++;
                else
                    r--;
            }
            return maxarea;
        }

}
