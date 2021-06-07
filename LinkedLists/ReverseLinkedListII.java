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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        
        ListNode prev=dummy;
        for(int i=1;i<m;i++)
        {
            prev=prev.next;
        }
        
        ListNode curr=prev.next;
        for(int i=m;i<n;i++)
        {
            ListNode next=curr.next;
            curr.next=next.next;
            next.next=prev.next;
            prev.next=next;
        }
        return dummy.next;
    }
}