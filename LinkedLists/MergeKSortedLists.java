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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode r=null;
        
        for(int i=0;i<lists.length;i++)
        {
            ListNode list=lists[i];
            
            r=mergeTwoLists(r,list);
        }
        return r;
        
        

        
    }
}