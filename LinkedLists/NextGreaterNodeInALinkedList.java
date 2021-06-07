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
    public int[] nextLargerNodes(ListNode head) {
        
        ListNode curr= head;
        int size=0;
        while(curr!=null)
        {
            size++;
            curr=curr.next;
        }
        Stack<int []>st= new Stack<>();
        int ans[]= new int[size];
        //Arrays.fill(ans,0);
        
        curr=head;
        int i=0;
        while(curr!=null)
        {
            
            while(st.size()!=0 && curr.val>st.peek()[1])
            {
                ans[st.pop()[0]]=curr.val;
            }
            st.push(new int[]{i,curr.val});
            i++;
            curr=curr.next;
        }
        return ans;
    }
}