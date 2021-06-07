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
    public List<TreeNode> pathFromNodeToRoot(TreeNode root, TreeNode target)
    {
        if(root == null)
            return null;
        if(root.val == target.val){
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }
        List<TreeNode> lans = pathFromNodeToRoot(root.left,target);
        if(lans != null)
        {
            lans.add(root);
            return lans;
        }
        List<TreeNode> rans = pathFromNodeToRoot(root.right,target);
        if(rans != null)
        {
            rans.add(root);
            return rans;
        }
        return null;
    }
    public void kNodesDown(TreeNode root, int k,ArrayList<Integer> arr,TreeNode blocked)
    {
        if(root ==  null || k < 0 || blocked == root)
            return;
        if(k == 0)
        {
            arr.add(root.val);
            return;
        }
        kNodesDown(root.left,k-1,arr,blocked);
        kNodesDown(root.right,k-1,arr,blocked);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> res = pathFromNodeToRoot(root,target);
        ArrayList<Integer> arr = new ArrayList<>();
        TreeNode blocked = null;
        
        for(int i = 0; i < res.size(); i++)
        {
            kNodesDown(res.get(i),k--,arr,blocked);
            blocked = res.get(i);
        }
        return arr;
    }
}