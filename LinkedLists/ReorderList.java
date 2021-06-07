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
    
     public ListNode middleList(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
        
        
        
    }
    public void reorderList(ListNode head) {
        ListNode mid=middleList(head);
        ListNode thead=mid.next;
        mid.next=null;
        thead=reverseList(thead);
        ListNode c1=head;
        ListNode c2=thead;
        
        while(c1!=null && c2!=null)
        {
            ListNode t1=c1.next;
            ListNode t2=c2.next;
            c1.next=c2;
            c2.next=t1;
            c1=t1;
            c2=t2;
        }
    }
}