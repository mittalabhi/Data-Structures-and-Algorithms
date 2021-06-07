class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        int psum = 0;
        hm.put(0,1);
        for(int i = 0; i < nums.length; i++)
        {
            psum += nums[i];
            if(hm.containsKey(psum - k))
            {
                count = count + hm.get(psum - k);
            }
            if(hm.containsKey(psum))
                hm.put(psum,hm.get(psum)+1);
            else
                hm.put(psum,1);
        }
        return count;
    }
}



/* O(n^3) solution
class Solution {
    public int subarraySum(int[] nums, int tar){
        int sum = 0;
         int count = 0;
        for(int i = 0;i < nums.length; i++){
            for(int j = i;j < nums.length; j++){
                for(int k = i; k <= j; k++){
                    sum += nums[k];
                }
                if(sum == tar)count++;
                sum = 0;

            }
        }
        return count;
    }
}
*/