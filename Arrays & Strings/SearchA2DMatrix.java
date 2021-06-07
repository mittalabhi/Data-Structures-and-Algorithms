class Solution {
    public boolean binarySearch(int[][] matrix,int r,int target){
        int lo = 0;
        int hi = matrix[0].length - 1;
        boolean ans = false;
        while(lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if(matrix[r][mid] == target)
                return true;
            else if(matrix[r][mid] > target)
                hi = mid -1;
            else
                lo = mid + 1;
        }
        return ans;
    }
    public int binarySearchRow(int[][] matrix,int target)
    {
        int lo = 0;
        int hi = matrix.length - 1;
        int lc = matrix[0].length - 1;
        
        while(lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if(matrix[mid][0] <= target && target <= matrix[mid][lc])
                return mid;
            else if(matrix[mid][0] > target)
                hi = mid -1;
            else
                lo = mid + 1;
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchRow(matrix,target);
        if(row == -1) return false;
        boolean ans = binarySearch(matrix,row,target);
        return ans;
    }
}