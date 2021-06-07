import java.util.*;
class DFSTOPO{
    static class Edge{
        int v;
        int w;
        Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    public static int N = 7;
    public static ArrayList<Edge> graph[] = new ArrayList[N];
    public static void  addEdge(int u,int v,int w){
        graph[u].add(new Edge(v,w));        
    }
    public static  void constructGraph(){
        for(int i = 0;i < N; i++){
            graph[i] = new ArrayList<>();
        }
        addEdge(0,1,10);
        addEdge(0,2,10);
        addEdge(1,3,15);
        addEdge(2,4,18);
        addEdge(4,5,25);
        addEdge(5,6,21);
    }
   
    public static void DFSTopo(int src,boolean[] visited,Stack<Integer> st )
    {
    	visited[src] = true;
    	for(Edge e:graph[src])
    	{
    		if(visited[e.v] != true)
    		{
    			DFSTopo(e.v,visited,st);
    		}
    	}
    	st.push(src);
    	}
    public static void TopologicalSort() {
    	boolean visited[] = new boolean[N];
    	
    	Stack<Integer> st = new Stack<>();
    	for(int i = 0; i < N;i++)
    	{
    		if(visited[i] == false)
    			DFSTopo(i,visited , st);
    	}
    	while(st.size() != 0)
    	{
    		System.out.println(st.pop());
    	}
    	
    }
    public static void main(String[] args){
        constructGraph();
        TopologicalSort();
    }
}