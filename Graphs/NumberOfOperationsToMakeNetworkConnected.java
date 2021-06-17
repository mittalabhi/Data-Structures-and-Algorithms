class Solution {
    public void dfs(boolean visited[],int src,ArrayList<Integer> graph[]){
        visited[src] = true;
        for(int ele : graph[src]){
            if(!visited[ele]){
                dfs(visited,ele,graph);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(n - 1 > edges) return -1;

        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i = 0;i < n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i < connections.length; i++){
            int src = connections[i][0];
            int des = connections[i][1];

            graph[src].add(des);
            graph[des].add(src);
        }
        boolean visited[] = new boolean[n];

        int count = 0;
        for(int i = 0;i < n; i++){
            if(!visited[i]){
                dfs(visited,i,graph);
                count++;
            }
        }
        return count -  1;

    }
}