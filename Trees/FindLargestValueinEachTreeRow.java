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
        public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        que.add(root);

        int max = Integer.MIN_VALUE;
        while(que.size() != 0){
            int size = que.size();
            while(size -- > 0){
                TreeNode vtx = que.removeFirst();
                max = Math.max(vtx.val,max);

                if(vtx.left != null) que.addLast(vtx.left);
                if(vtx.right != null) que.addLast(vtx.right);
            }
            ans.add(max);
            max = Integer.MIN_VALUE;
        }
        return ans;
    }

    
}