class Solution {
    class Edge{
        int v;
        int w;
        Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    public int countNeighbours(ArrayList<Edge> graph[], int src, int threshold){
        LinkedList<Integer> que = new LinkedList<>();
        boolean []visited = new boolean[graph.length];
        int dis[] = new int[graph.length];
        Arrays.fill(dis,(int)1e9);
        dis[src] = 0;
        que.addLast(src);
        
        while(que.size() != 0)
        {
            int size = que.size();
            
            while(size --> 0){
                
                int vtx = que.removeFirst();
                visited[vtx] = true;
                
                for(Edge e: graph[vtx]){
                    int vt = e.v;
                    int wt = e.w;
                    if(dis[vtx] + wt < dis[vt]){
                        dis[vt] = dis[vtx] + wt;
                    }
                    if(dis[vt] + wt < dis[vtx]){
                        dis[vtx] = dis[vt] + wt;
                    }
                    
                    
                    if(!visited[e.v])
                        que.addLast(vt);
                    
                }
            }
        }
        int count = 0;
        for(int i = 0;i < dis.length;i++)
        {
            if(i != src && dis[i] <= threshold)
            {
                count++;
            }
        }
        return count;
        
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int ans = -1;
        int res = (int)1e9;
        ArrayList<Edge> graph[] = new ArrayList[n];
        
        for(int i = 0;i < n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0;i < edges.length;i++){
            int src = edges[i][0];
            int des = edges[i][1];
            int wt =  edges[i][2];
            
            Edge e1 = new Edge(des,wt);
            Edge e2 = new Edge(src,wt);
            
            graph[src].add(e1);
            graph[des].add(e2);
        }
        for(int i = 0;i < graph.length;i++)
        {
            System.out.print(graph[i] + ",");
        }
        for(int src = 0; src < graph.length;src++){
            
            int count = countNeighbours(graph,src,distanceThreshold);
            System.out.print(count + " ");
            if(count <= res){
                res = count;
                ans = src;
                
            }
        }
        return ans;
    }
}