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
    public ListNode partition(ListNode head, int x) {
        
        ListNode thead=head;
        ListNode ans1= new ListNode(0);
        ListNode ans2= new ListNode(0) ;
        ListNode one=ans1;
        ListNode two=ans2;
        while(thead!=null)
        {
            if(thead.val<x)
            {
                one.next=new ListNode(thead.val);
                //one.next=null;
                one=one.next;
            }
            else
            {
                two.next=new ListNode(thead.val);
                //two.next=null;
                two=two.next;
            }
            thead=thead.next;
        }
        one.next=ans2.next;
        return ans1.next;
        
        
    }
}