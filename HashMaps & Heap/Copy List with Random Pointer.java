/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        HashMap<Node,Node> hm = new HashMap<>();
        
        Node curr= head;
        
        while(curr!=null)
        {
            Node node = new Node(curr.val);
            
            hm.put(curr,node);
            curr=curr.next;
            
        }
        curr = head;
        
        while(curr!=null)
        {
            Node resultNode= hm.get(curr);
            
            if(hm.containsKey(curr.next))
            {
                resultNode.next=hm.get(curr.next);
            }
            else
            {
                resultNode.next=null;
            }
             if(hm.containsKey(curr.random))
            {
                resultNode.random=hm.get(curr.random);
            }
            else
            {
                resultNode.random=null;
            }
            curr=curr.next;
        }
        return hm.get(head);
        
    }
}