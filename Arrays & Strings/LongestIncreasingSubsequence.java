//O(nlogn) BinarySearch
class Solution {
    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele: nums){
            int idx = Collections.binarySearch(ans,ele);
            if(idx < 0) idx = -idx - 1;

            if(idx == ans.size()){
                ans.add(ele);
            }

            ans.set(idx,ele);
        }
        return ans.size();
    }
}
