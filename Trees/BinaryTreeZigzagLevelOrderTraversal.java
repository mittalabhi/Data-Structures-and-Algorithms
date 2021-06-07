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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        que.addLast(root);
        int level = 0;
        while(que.size() != 0)
        {
            int size = que.size();
            List<Integer> res = new ArrayList<>();
            while(size -->0)
            {
                TreeNode vtx = que.removeFirst();
                res.add(vtx.val);
                if(vtx.left != null) que.add(vtx.left);
                if(vtx.right != null) que.add(vtx.right);
            }
            if(level % 2 != 0)Collections.reverse(res);
            level++;
            ans.add(new ArrayList<>(res));
        }
        return ans;
        
    }
}