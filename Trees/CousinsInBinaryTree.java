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
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean xp = false;
        boolean yp = false;

        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        while(que.size() != 0){
            int size = que.size();
            while(size -- > 0){
                TreeNode vtx = que.removeFirst();
                if(vtx .val == x) xp = true;
                if(vtx.val == y) yp = true;

                if(vtx.left != null && vtx.right != null){
                    if(vtx.left.val == x && vtx.right.val == y) return false;
                    if(vtx.left.val == y && vtx.right.val == x) return false;

                }
                if(vtx.left != null) que.addLast(vtx.left);
                if(vtx.right != null)que.addLast(vtx.right);
            }
            if(xp == true && yp == true) return true;
            xp = false;
            yp = false;
        }
        return false;

    }

}