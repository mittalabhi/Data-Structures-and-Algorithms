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
    class Pair{
        long idx;
        TreeNode node;
        Pair(TreeNode node,long idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        long maxWidth = Long.MIN_VALUE;
        LinkedList<Pair> que = new LinkedList<>();
        Pair newNode = new Pair(root,0);
        que.addLast(newNode);
        while(que.size() != 0){
            long size = que.size();
            maxWidth = Math.max(maxWidth,que.peekLast().idx - que.peekFirst().idx + 1);
            while(size-- > 0){
                Pair vtx = que.removeFirst();
                TreeNode node = vtx.node;
                long idx = vtx.idx;
                System.out.println(idx);
                if(node.left != null) que.addLast(new Pair(node.left,2 * idx));
                if(node.right != null) que.addLast(new Pair(node.right,2 * idx + 1));
            }
        }
        return (int)maxWidth;
    }
}
