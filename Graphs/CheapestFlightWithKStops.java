class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int count = 0;
        for(int i = 0;i < flights.length; i++){
            if(flights[i][1] == dst) count++;
        }
        if(count == 0) return -1;
        LinkedList<int[]> que = new LinkedList<>();
        int cost = 0;
        que.add(new int[]{src,cost});
        int minCost = (int)1e9;
        int level = 0;
        boolean visited[] = new boolean[n];
        while(que.size() != 0  && k != -2){
            int size = que.size();
            while(size -- > 0){
                int node[] = que.removeFirst();
                int s = node[0];
                int c = node[1];
                if(s == dst){
                    minCost = Math.min(minCost,c);
                }
                for(int i = 0;i < flights.length ;i++){
                    if(flights[i][0] == s){
                        if(c + flights[i][2] > minCost) continue;
                        que.addLast(new int[]{flights[i][1],c + flights[i][2]});
                    }
                }
            }
            k--;
            level ++;
        }
        return minCost == (int)1e9 ? -1 : minCost;
    }

    
}