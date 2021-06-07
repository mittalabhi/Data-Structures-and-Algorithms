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
    
   static ListNode th=null;
    static ListNode tt=null;
    private static void addFirst(ListNode node)
    {
        if(th==null)
        {
            th=node;
            tt=node;
        }
        else
        {
            node.next=th;
            th=node;
        }
    }
    private static int length(ListNode node)
    {
        ListNode curr= node;
        int len=0;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null||head.next==null||k<1)
            return head;
        
        ListNode curr=head;
        ListNode oh=null,ot=null;
        int len=length(head);
        
        while(len>=k)
        {
            int ktemp=k;
            while(ktemp>0)
            {
                ListNode f=curr.next;
                curr.next=null;
                addFirst(curr);
                curr=f;
                ktemp--;
            }
            if(oh==null)
            {
                oh=th;
                ot=tt;
            }
            else
            {
                ot.next=th;
                ot=tt;
            }
            th=null;
            tt=null;
            len-=k;
        }
        ot.next=curr;
        return oh;
        
    }
}