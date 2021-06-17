class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        ArrayList<Integer> graph[] = new ArrayList[n];
        
        for(int i = 0;i < graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0;i < edges.size();i++)
        {
            int src = edges.get(i).get(0);
            int des = edges.get(i).get(1);
            
            graph[src].add(des);
        }
        int indegree[] = new int[n];
        
        for(int src = 0; src < graph.length;src++)
        {
            ArrayList<Integer> arr = graph[src];
            for(int ele : arr)
            {
                indegree[ele]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i < indegree.length;i++){
            if(indegree[i] == 0) ans.add(i);
        }
        return ans;
    }
}