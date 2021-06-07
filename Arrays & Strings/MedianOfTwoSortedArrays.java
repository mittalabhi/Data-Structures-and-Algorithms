class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2,nums1);
        
        int lo = 0;
        int hi = nums1.length;
        
        while(lo <= hi)
        {
            int partitionX = (lo + hi) / 2;
            int partitionY = (nums1.length + nums2.length + 1) / 2 - partitionX;
            
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == nums1.length) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == nums2.length) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxX <= minY && maxY <= minX)
            {
                if((nums1.length + nums2.length) % 2 == 0)
                {
                    double ans = (double)(Math.max(maxX,maxY) + Math.min(minX,minY)) / 2;
                    return ans;
                }
                else
                {
                    return (double)Math.max(maxX,maxY);
                }
            }
            else if(maxX > minY)
            {
                hi = partitionX - 1;
            }
            else
            {
                lo = partitionX + 1;
            }
            
        }
        return -1;
    }
}