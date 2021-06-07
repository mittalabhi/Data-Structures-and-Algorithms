class Solution {

    public int findPar(int u,int par[]){
        if(par[u] == u){
            return u;
        }
        return par[u] = findPar(par[u],par);
    }
    public void merge(int vtx1,int vtx2,int []size,int par[]){
        if(size[vtx1] < size[vtx2]){
            par[vtx1] = par[vtx2];
            size[vtx2] += size[vtx1];
        }
        else{
            par[vtx2] = par[vtx1];
            size[vtx1] += size[vtx2];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {


        int par[] = new int[edges.length + 1];
        int size[] = new int[edges.length + 1];

        for(int i = 1;i < edges.length + 1; i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int edge[] : edges){
            int vtx1 = edge[0];
            int vtx2 = edge[1];

            int par1 = findPar(vtx1,par);
            int par2 = findPar(vtx2,par);

            if(par1 != par2){
                merge(par1,par2,size,par);
            }
            else{
                return edge;
            }
        }

        return new int[]{};
    }

}