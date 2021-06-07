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
class BSTIterator {
ArrayList<Integer> ans;
    int p = -1;
    public BSTIterator(TreeNode root) {
        ans = new ArrayList<>();
        inorder(root,ans);
    }

    public int next() {
        return ans.get(++p);
    }

    public boolean hasNext() {
        return p == ans.size() - 1 ? false : true;
    }
    public void inorder(TreeNode root, ArrayList<Integer> ans){
        if(root == null) return;

        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */