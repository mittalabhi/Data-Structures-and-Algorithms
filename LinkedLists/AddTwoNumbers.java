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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode ans=new ListNode(0);
            ListNode curr=ans;
        
        int carry=0;
        ListNode c1 =l1;
        ListNode c2=l2;
            int value=0;
        
        while(c1!=null || c2!=null)
        {
            if(c1==null)
            {
             value =carry+c2.val;
                
 
            }
            else if(c2==null)
                   value =carry+c1.val;
            else
            value =carry+c1.val+c2.val;
            if(value<10)
            {
                curr.next= new ListNode(value);
                curr=curr.next;
                carry=0;
            }
            else
            {
                int num= value%10;
                carry=1;
                curr.next= new ListNode(num);
                curr=curr.next;
            }
            if(c1!=null)
            c1=c1.next;
            if(c2!=null)
            c2=c2.next;
            
        }
        if(carry==1)
            curr.next= new ListNode(1);
                curr=curr.next;
        
        return ans.next;
        
    }
}