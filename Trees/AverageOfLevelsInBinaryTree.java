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
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        que.addLast(root);
        double res =0.0;
        while(que.size() != 0)
        {
            
            int size = que.size();
            int s = que.size();
            while(size --> 0){
                TreeNode vtx = que.removeFirst();               
                if(vtx.left != null)
                {
                    que.add(vtx.left);
                }
                if(vtx.right != null)
                {
                    que.add(vtx.right);
                }
                res += vtx.val;
            }
            double avg = res/s;
            s = 0;
            res = 0.0;
            ans.add(avg);
        }
        return ans;
    }
}