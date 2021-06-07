class LRUCache {
    int  cap = 0;
    int  count = 0;
    class Node{
        int key = 0;
        int val = 0;
        Node next = null;
        Node prev = null;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer,Node> hm;
    Node head = null;
    Node tail = null;
    
        
    public LRUCache(int capacity) {
        cap = capacity;
        hm = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        
    }
        
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        int ans = hm.get(key).val;
        removeLL(hm.get(key));
        addFirst(hm.get(key));
        return ans;
        
    }
    
    public void put(int key, int val) {
        
        Node temp = new Node(key,val);
        if(hm.containsKey(key)){
                removeLL(hm.get(key));
                hm.remove(key);
                hm.put(key,temp);
                addFirst(temp);
            
                
        }
        else{
            if(count < cap){
                hm.put(key,temp);
                addFirst(temp);
                count++;
                //System.out.print(count+" ");
            }
            else{

                hm.remove(tail.prev.key);
                removeLL(tail.prev);
                hm.put(key,temp);
                addFirst(temp);

            }
        }
    
        
        
        
    }
    public void addFirst(Node temp){
        temp.next = head.next;
        temp.next.prev = temp;
        head.next = temp;
        temp.prev = head;
    }
    public void removeLL(Node temp){
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }
        
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */