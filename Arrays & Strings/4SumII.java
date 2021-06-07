class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hm  = new HashMap<>();
        for(int ele1 : nums1){
            for(int ele2: nums2){
                if(hm.containsKey(ele1 + ele2)){
                    hm.put(ele1 + ele2,hm.get(ele1 + ele2) + 1);
                }
                else{
                    hm.put(ele1 + ele2,1);
                }
            }
        }
        int count = 0;
        for(int ele1 : nums4){
            for(int ele2 : nums3){
                if(hm.containsKey(-(ele1 + ele2))){
                    count += hm.get(-(ele1 + ele2));
                }
            }
        }
        return count;
    }
}
