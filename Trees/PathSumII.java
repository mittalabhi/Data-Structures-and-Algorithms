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
    List<List<Integer>> ans = new ArrayList<>();
    public void pathSumHelper(TreeNode root,int targetSum,List<Integer> base){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                base.add(root.val);
                ans.add(new ArrayList<>(base));
                System.out.println(ans);
                base.remove(base.size()-1);
            }
            return;
        }
        base.add(root.val);
        //stem.out.println(base);
        if(root.left != null)  pathSumHelper(root.left,targetSum - root.val,base);
        if(root.right != null) pathSumHelper(root.right,targetSum - root.val,base);
        base.remove(base.size() -1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> base = new ArrayList();

        pathSumHelper(root,targetSum,base);

        return ans;
    }

}