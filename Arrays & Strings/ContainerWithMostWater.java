class Solution {
    public int maxArea(int[] height) {
        int i = 0,j = height.length - 1;
        int res = 0;
        while(i < j){
            int width = j - i;
            if(height[i] < height[j]){
                res = Math.max(res,height[i++] * width);
            }
            else{
                res = Math.max(res,height[j--] * width);
            }
        }
        return res;
    }
}
