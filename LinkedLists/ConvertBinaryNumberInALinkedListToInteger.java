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
    public int findSize(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(head != null){
            count ++;
            head = head.next;
        }
        return count;
    }
    public int getDecimalValue(ListNode head) {
        int size = findSize(head);
        int res = 0;
        while(head != null){
            res += Math.pow(2,size - 1) * head.val;
            size--;
            head = head.next;
        }
        return res;
    }
}