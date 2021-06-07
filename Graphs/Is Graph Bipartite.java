class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color,-1); 
        boolean ans = true;
        for(int i=0;i<graph.length;i++){
            if(color[i] == -1){
                ans = bfs(graph,color,i);

                if(!ans) return false;
            }
        }
       return true; 
    }
    public boolean bfs(int [][] graph,int color[],int src){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        int colorv = 0;

        while(queue.size() != 0){
            int size = queue.size();
            while(size-- > 0){
                int vtx = queue.removeFirst();

                if(color[vtx] != -1){
                    if(color[vtx] != colorv){
                        return false;
                    }
                }

                color[vtx] = colorv;
                for(int ele: graph[vtx]){
                    if(color[ele] == -1){
                        queue.addLast(ele);
                    }
                }
            }
            colorv = (colorv + 1) % 2;
        }
        return true;

    }

}