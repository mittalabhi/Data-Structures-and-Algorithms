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
     public ListNode middleNode(ListNode head) {
        if(head==null)
            return null;
         ListNode fast=head;
        ListNode slow=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
       }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode ans = new ListNode(0);
        ListNode temp=ans;

        ListNode c1=l1;
        ListNode c2=l2;
        
        while(c1!=null && c2!=null)
        {
            if(c1.val<=c2.val)
            {
                temp.next=new ListNode(c1.val);
                temp=temp.next;

                c1=c1.next;
            }
            else 
            {
                temp.next=new ListNode(c2.val);
                temp=temp.next;

                c2=c2.next;
            }
        }
        while(c1!=null)
        {
                temp.next=new ListNode(c1.val);
                temp=temp.next;

                c1=c1.next;
        }
         while(c2!=null)
        {
                temp.next=new ListNode(c2.val);
                temp=temp.next;
                c2=c2.next;
        }
        return ans.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode mid=middleNode(head);
        ListNode nex=mid.next;
        mid.next=null;
        
        ListNode left= sortList(head);
        ListNode right=sortList(nex);
        ListNode ans =mergeTwoLists(left,right);
        return ans;
        
        
        
    }
}