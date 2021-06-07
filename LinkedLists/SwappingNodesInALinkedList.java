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
    public ListNode swapNodes(ListNode head, int k) {
        
        k=k-1;
        ListNode curr=head;
        
        while(k>0)
        {
            curr=curr.next;
            k--;
        }
        ListNode tempcurr=curr;
        ListNode second=head;
        
        while(tempcurr.next!=null)
        {
            tempcurr=tempcurr.next;
            second=second.next;
        }
        
        int temp=curr.val;
        curr.val=second.val;
        second.val=temp;
        
        return head;
    }
}