/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      if(root == null) return new ArrayList<>();
      LinkedList<TreeNode> que = new LinkedList<>();
      que.addLast(root);
      ArrayList<Integer> ans = new ArrayList<>();
      int level = 0;
      int idx = 1;
      while(que.size() != 0){
          int size = que.size();
          int s = que.size();
          while(size -- > 0){
              TreeNode vtx = que.removeFirst();
              if(idx == s)ans.add(vtx.val);
              idx++;

              if(vtx.left != null) que.addLast(vtx.left);
              if(vtx.right != null)que.addLast(vtx.right);
        }
         idx = 1;
    }
      return ans;

    }
}