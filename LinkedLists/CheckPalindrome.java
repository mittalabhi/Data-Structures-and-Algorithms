/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode pleft;
    private boolean IspalinHelper(ListNode right)
    {
        if(right==null)
        {
            return true;
        }
        boolean result= IspalinHelper(right.next);
        if(result==false)
            return false;
        else if(pleft.val!=right.val)
            return false;
        else
        {
            pleft=pleft.next;
            return true;
        }
    }
    public boolean isPalindrome(ListNode head) {
         pleft=head;
        
        return IspalinHelper(head);
        
    }
}