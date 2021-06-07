class Solution {
        int orgColor = 0;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        orgColor = image[sr][sc];
        floodFillHelper(image,sr,sc,newColor,visited);
        return image;

    }
    public void floodFillHelper(int [][]image, int sr,int sc,int newColor,boolean visited[][]){
        if(sr < 0 || sc < 0 || sr > image.length -1 || sc > image[0].length -1 || visited[sr][sc] == true){
            return ; 
        }
        if(image[sr][sc] != orgColor){
            return;
        }
        visited[sr][sc] = true;
        if(image[sr][sc] == orgColor){
            image[sr][sc] = newColor;
        }
        floodFillHelper(image,sr,sc+1,newColor,visited);
        floodFillHelper(image,sr,sc-1,newColor,visited);
        floodFillHelper(image,sr-1,sc,newColor,visited);
        floodFillHelper(image,sr+1,sc,newColor,visited);
        visited[sr][sc] = false;

    }

}