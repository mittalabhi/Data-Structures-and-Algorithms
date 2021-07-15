/*
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /*
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */
    TreeNode prev = null;
    TreeNode head = null;
    public void treeToDoublyListH(TreeNode root){
        if(root == null) return;

        treeToDoublyListH(root.left);
            if(head == null) head = root;
            else{
                prev.right = root;
                root.left = prev;
            }
            prev = root;

        treeToDoublyListH(root.right);
    }
    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
         treeToDoublyListH(root);

         root = head;
            prev.right = head;
            head.left = prev;
         return root;
    }
}
