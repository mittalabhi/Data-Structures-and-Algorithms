import java.util.*;
class graphMittal{
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
        graph[v].add(new Edge(u,w));
    }
    public static  void constructGraph(){
        for(int i = 0;i < N; i++){
            graph[i] = new ArrayList<>();
        }
        addEdge(0,1,10);
        addEdge(0,2,10);
        addEdge(1,3,15);
        addEdge(3,2,20);
        addEdge(2,4,18);
        addEdge(4,5,25);
        addEdge(5,6,21);
        addEdge(4,6,30);
       // removeEdge(4,6);
        removeVertice(2);

    }
    public static int getIdx(int u,int v){
        int i = 0;
        for(Edge e: graph[u]){
            if(e.v == v){
                return i;
            }
            i++; 
        }
        return -1;
    }
    public static void removeEdge(int u,int v){
        int idx1 = getIdx(u,v);
        graph[u].remove(idx1);
        int idx2 = getIdx(v,u);
        graph[v].remove(idx2);
    }
    public static void removeVertice(int u){
        int n = graph[u].size();
        for(int i = n -1; i >= 0; i--){
            Edge e = graph[u].get(i);
            removeEdge(u,e.v);
        }
    }
    public static void displayGraph(){
        for(int i = 0;i < graph.length; i++){
            System.out.print(i + "->");
            for(Edge e : graph[i]){
                System.out.print(" (" + e.v + "," + e.w + ")");
            }
            System.out.println();
        }
    }
    public boolean hasPath(int src,int des,boolean visited){
        if(src == des){
            return true;
        }
        visited[src] = true;
        for(Edge e: graph[src]){
            if(visited[e.v] == false){
                boolean ans = hasPath(e.v,des);
                if(ans == true){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        constructGraph();
        displayGraph();
    }
}