class Solution {
    class Edge{
        int v;
        double succPro;
        Edge(int v,double succPro){
            this.v = v;
            this.succPro = succPro;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        ArrayList<Edge> graph[] = new ArrayList[n];
        
        for(int i = 0; i < n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0;i < edges.length;i++)
        {
            int src = edges[i][0];
            int des = edges[i][1];
            double succPro = succProb[i];
            Edge e1 = new Edge(des,succPro);
            Edge e2 = new Edge(src,succPro);
            
            graph[src].add(e1);
            graph[des].add(e2);

        }
        PriorityQueue<double []> pq = new PriorityQueue<>((a,b) -> { return Double.compare(b[1],a[1]);});
        double dis[] = new double[n];
        dis[start] = 1.0;
        pq.add(new double[]{(double)start,1.0});
        
        while(pq.size() != 0){
            int size = pq.size();
            while(size --> 0){
                double arr[] = pq.poll();
                int vtx = (int)arr[0];
                double prob = arr[1];
                if(vtx == end)
                    return prob;
                
                for(Edge e: graph[vtx]){
                    int vt = e.v;
                    double probNew = e.succPro;
                    if(dis[vtx] * probNew > dis[vt]){
                        dis[vt] = dis[vtx] * probNew;
                        pq.add(new double[]{vt,dis[vt]});
                    }
                }
                
            }
        }
        return 0.0;
    }
}