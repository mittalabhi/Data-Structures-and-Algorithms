class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue <int []> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        for(int i=0;i<points.length;i++)
        {
            int dis= ((points[i][0])*(points[i][0]))+((points[i][1])*(points[i][1]));
            pq.add(new int[] {i,dis});
        }
        int [][] ans = new int[k][2];
        int c=0;
        while(k!=0)
        {
            int temp=pq.poll()[0];   
            ans[c][0]=points[temp][0];
            ans[c][1]=points[temp][1];
            c++;
            k--;
        }
        return ans;
    }
}