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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        int c=1;
        
        ListNode t=head;
        while(t.next!=null)
        {
            c+=1;
            t=t.next;
        }
        t.next=head;
        
        k=k%c;
        for(int i=0;i<c-k;i++)
        {
            t=t.next;
        }
       ListNode ans= t.next;
        t.next=null;
        return ans;
        
    }
}