class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))
            {
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else
                hm.put(nums[i],1);
        }
        
        PriorityQueue<int []> pq= new PriorityQueue<>((a,b)->{
        return b[1]-a[1];
            });
        
        for(int i=0;i<nums.length;i++)
        { 
            if(hm.containsKey(nums[i]))
            {
                pq.add(new int[] {nums[i],hm.get(nums[i])});
                hm.remove(nums[i]);
            }
        }
        int arr[]= new int[k];
        
        for(int i=0;i<k;i++)
        {
            arr[i]=pq.poll()[0];
        }
        return arr;
        
    }
}