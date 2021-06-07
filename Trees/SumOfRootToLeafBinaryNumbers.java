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
    int finAns = 0;
    public int binaryToDecimal(String str){
        int n = str.length() - 1;
        int ans = 0;
        int exp = 0;
        while(n >= 0){
            int ch = str.charAt(n) - '0';
            ans +=  Math.pow(2,exp) * ch;
            n--;
            exp++;
        }
        return ans;
    }
    public void sumHelper(TreeNode root,String psf){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            int dec = binaryToDecimal(psf);
            System.out.println(psf);
            finAns += dec;
            return;
        }
        if(root.left!=null) sumHelper(root.left,psf + root.left.val);
        if(root.right!= null)sumHelper(root.right,psf + root.right.val);
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root == null){
            return 0;
        }
        sumHelper(root,""+root.val);
        return finAns;
    }
}
