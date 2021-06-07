/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=0;
        int l2=0;
        ListNode c1=headA;
        ListNode c2=headB;
        
        while(c1!=null)
        {
            l1++;
            c1=c1.next;
        }
        while(c2!=null)
        {
            l2++;
            c2=c2.next;
        }
        int diff=Math.abs(l1-l2);
        ListNode a1=headA;
        ListNode a2=headB;
        if(l1>l2)
        {
            for(int i=0;i<diff;i++)
            {
                a1=a1.next;
            }
        }
        else
        {
            for(int i=0;i<diff;i++)
            {
                a2=a2.next;
            }
        }
        while(a1!=a2)
        {
            a1=a1.next;
            a2=a2.next;
        }
        return a1;
    }
}