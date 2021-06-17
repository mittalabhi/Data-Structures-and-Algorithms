class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<Integer> graph[] = new ArrayList[edges.length + 1];
        
        for(int i = 0;i < graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i < edges.length;i++)
        {
            int src = edges[i][0];
            int des = edges[i][1];
            
            graph[src - 1].add(des - 1);
            graph[des - 1].add(src - 1);
        }
        int ans = -1;
        for(int i = 0;i < graph.length;i++){
            if(graph[i].size() > 1) ans = i + 1;
        }        
       return ans;
    }
}