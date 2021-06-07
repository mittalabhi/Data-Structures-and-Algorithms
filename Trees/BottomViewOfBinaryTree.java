class Tree
{
    //Function to return a list containing the bottom view of the given tree.
    class Pair{
        Node root;
        int dis;
        Pair(Node root,int dis){
            this.root = root;
            this.dis = dis;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        int min = (int)1e9;
        int max = -(int)1e9;
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        LinkedList<Pair> que = new LinkedList<>();
        Pair newPair = new Pair(root,0);
        que.addLast(newPair);
        
       
        
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                Pair vtx = que.removeFirst();
                Node newNode = vtx.root;
                int dis = vtx.dis;
                min = Math.min(min,dis);
                max = Math.max(max,dis);
                
                if(newNode.left != null){
                    Pair newPair2 = new Pair(newNode.left,dis - 1);
                    que.addLast(newPair2);
                }
                if(newNode.right != null){
                    Pair newPair2 = new Pair(newNode.right,dis + 1);
                    que.addLast(newPair2);
                }
                
                if(hm.containsKey(dis)){
                    ArrayList<Integer> arr = hm.get(dis);
                    arr.add(newNode.data);
                    hm.put(dis,arr);
                }
                else{
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(newNode.data);
                    hm.put(dis,arr);
                }
                
                
            }
        }
        //System.out.println(hm.size());
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = min; i <= max; i++){
            ArrayList<Integer> res = hm.get(i);
           // System.out.println(res);
            ans.add(res.get(res.size() -1));
        }
        return ans;
    }
}