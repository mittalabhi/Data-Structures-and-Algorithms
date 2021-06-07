/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public ArrayList<TreeNode>  nodePath(TreeNode root,TreeNode node){
        if(root == null){
            return null;
        }
        if(node.val == root.val){
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }
        ArrayList<TreeNode> lPath = nodePath(root.left,node);
        if(lPath != null){
            lPath.add(root);
            return lPath;
        }
        ArrayList<TreeNode> rPath = nodePath(root.right,node);
        if(rPath != null){
            rPath.add(root);
            return rPath;
        }
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> anc1 = nodePath(root,p);
        ArrayList<TreeNode> anc2 = nodePath(root,q);
        System.out.print(anc1);
        System.out.print(anc2);
        TreeNode ans = null;
        int n = anc1.size() - 1;
        int m = anc2.size() - 1;
        while(!(n < 0 || m < 0)){
            TreeNode node1 = anc1.get(n);
            TreeNode node2 = anc2.get(m);
            if(node1.val == node2.val){
                ans = node1;
            }
            n--;
            m--;
        }
        return ans;
    }
}