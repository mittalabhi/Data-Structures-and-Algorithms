/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)){
                if(mid - 1 >= 1 && isBadVersion(mid - 1)){
                    hi = mid - 1;
                }
                else{
                    return mid;
                }
            }
            else if(!isBadVersion(mid)){
                lo = mid + 1;
            }

        }
        return -1;



    }
}
