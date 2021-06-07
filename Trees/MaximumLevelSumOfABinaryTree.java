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
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        int sum = 0;
        int ans = 0;
        int max = -(int)1e9;
        while(que.size() != 0){
            int size = que.size();
            while(size -- > 0){
                TreeNode vtx = que.removeFirst();
                sum += vtx.val;

                if(vtx.left != null) que.addLast(vtx.left);
                if(vtx.right != null) que.addLast(vtx.right);

            }
            if(sum > max){

                ans = level;
                max = sum;
            }
            level++;
            sum = 0;
        }
        return ans;
    }

}