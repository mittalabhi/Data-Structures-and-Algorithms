class Solution {
    
    public int greateronRight(int[] height,int index)
    {
        int gr=0;
        for(int i=index;i<height.length;i++)
        {
            if(height[i]>gr)
                gr=height[i];
        }
        return gr;
    }
    public int greateronLeft(int[] height,int index)
    {
        int gl=0;
        for(int i=index;i>=0;i--)
        {
            if(height[i]>gl)
                gl=height[i];
        }
        return gl;
    }
    
    public int trap(int[] height) {
        
        int sum=0;
        int gol=0;
        int gor=0;
        for(int i=0;i<height.length;i++)
        {
             gol=greateronLeft(height,i);
             gor=greateronRight(height,i);
            
            int min=Math.min(gol,gor);
            if(min!=0)
                sum+=min-height[i];
        }
        return sum;
        
    }
}