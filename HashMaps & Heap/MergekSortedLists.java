class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(-1);
        ListNode finAns = ans;

        PriorityQueue <ListNode > pq = new PriorityQueue<>((a,b) -> {return a.val - b.val;});
        for(int i = 0; i < lists.length; i++)
        {
            if(lists[i] != null)
                pq.add(lists[i]);
        }
        while(pq.size() != 0){
            ListNode popped = pq.peek();
            pq.poll();
            ans.next = new ListNode(popped.val);
            ans = ans.next;
            if(popped.next != null){
                pq.add(popped.next);
            }
        }
        return finAns.next;

    }
}