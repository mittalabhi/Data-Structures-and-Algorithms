class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))
                hm.put(nums[i],hm.get(nums[i])+1);
            else
                hm.put(nums[i],1);
        }
        ArrayList<Integer> ar= new ArrayList<>();
        for(Integer i:hm.keySet())
        {
            if(ar.contains(hm.get(i)))
                return false;
            else
                ar.add(hm.get(i));
        }
        return true;
    }
}