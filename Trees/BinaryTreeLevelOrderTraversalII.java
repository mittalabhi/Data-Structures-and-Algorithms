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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
if(root == null)
            return new ArrayList<>();
        LinkedList<List<Integer>> ans = new LinkedList<>();
        int level = 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        while(que.size() != 0)
        {
             List<Integer> res = new ArrayList<>();

            int size = que.size();
            while(size --> 0)
            {
                TreeNode vtx = que.removeFirst();
                res.add(vtx.val);
                if(vtx.left != null)
                {
                    que.add(vtx.left);
                }
                if(vtx.right != null)
                {
                    que.add(vtx.right);
                }
            }
            level++;
            ans.addFirst(new ArrayList<>(res));
            
        }
       return ans;
        
    }
}