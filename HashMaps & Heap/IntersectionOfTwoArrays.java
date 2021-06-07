class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    
        HashMap<Integer,Integer> hm= new HashMap<>();
        
        ArrayList<Integer> a = new ArrayList<>();
        
        for(int i=0;i<nums1.length;i++)
        {
            if(hm.containsKey(nums1[i]))
                hm.put(nums1[i],hm.get(nums1[i])+1);
            else
                hm.put(nums1[i],1);
        }
        
        for(int i=0;i<nums2.length;i++)
        {
            if(hm.containsKey(nums2[i]))
            {
                a.add(nums2[i]);
                hm.remove(nums2[i]);
            }
        }
        int arr[]=new int[a.size()];
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=a.get(i);
        }
        return arr;

    }
}