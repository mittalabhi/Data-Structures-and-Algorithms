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
                ListNode ans=new ListNode();
    
    


    int data=0;
    int oc=0;
   
    private int addHelper(ListNode one, int val1, ListNode two, int val2)
    {
        if(one==null&& two==null)
            return 0;
            
        if(val1>val2)
        {
             oc=addHelper(one.next,val1-1,two,val2);
             data=one.val+oc;
        }
        else if(val2>val1)
        {
              oc=addHelper(one,val1,two.next,val2-1);
             data=two.val+oc;

        }
        else
        {
            oc=addHelper(one.next,val1-1,two.next,val2-1);
             data=one.val+two.val+oc;

        }
        
        int newData=data%10;
        ListNode temp= new ListNode();
        temp.val=newData;
        temp.next=ans;
        ans=temp;
       
        int newCarry=data/10;
        return newCarry;
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode curr=l1;
        ListNode curr1=l2;
        int count=0;
        int count1=0;
        while(curr!=null)
        {
            count++;
            curr=curr.next;
        }
         while(curr1!=null)
        {
            count1++;
            curr1=curr1.next;
        }
        int carry=addHelper(l1,count,l2,count1);
        if(carry>0)
        {
            ListNode a= new ListNode();
            a.val=carry;
            a.next=ans;
            ans=a;
        }
        ListNode t=ans;
        while(t.next.next!=null)
        {
            t=t.next;
        }
        t.next=null;
        return ans;
    }
    
}