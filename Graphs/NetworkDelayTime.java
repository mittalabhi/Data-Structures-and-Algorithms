class Solution {
    class Edge{
        int v;
        int w;
        Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        if(k > n) return -1;
        
        ArrayList<Edge> graph[] = new ArrayList[n];
        
        for(int i = 0;i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0;i < times.length;i++){
            int src = times[i][0] - 1;
            int des = times[i][1] - 1;
            int w = times[i][2];
            
            Edge e = new Edge(des,w);
            graph[src].add(e);
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> { return a[1] - b[1];});
        int []distance = new int[n];
        Arrays.fill(distance, (int)1e9);
        distance[k - 1] = 0;
        boolean []visited = new boolean[n];
        pq.add(new int[]{k - 1,0});
        while(pq.size() != 0){
            int size = pq.size();
            while(size --> 0){
                int arr[] = pq.poll();
                int node = arr[0];
                if(visited[node]) continue;
                int dis = arr[1];
                visited[node] = true;
                
                for(Edge e: graph[node]){
                    int vt = e.v;
                    int wt = e.w;
                    if(dis + wt < distance[vt])
                    {
                        distance[vt] = dis + wt;
                    }
                    if(!visited[vt])
                        pq.add(new int[]{vt,distance[vt]});
                }
            }

            }
        for(int ele:distance)
            System.out.print(ele+ " " );
        int max = -(int)1e9;
            for(int i = 0;i < distance.length;i++){
                if(distance[i] == (int)1e9) return -1;
                max = Math.max(max,distance[i]);
        }
        
        return max;

    }
}