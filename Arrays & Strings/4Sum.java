class Solution {
    public List<List<Integer>> twoSum(int arr[],int target,int si,int ei){
        List<List<Integer>> ans = new ArrayList<>();
        while(si < ei){
            int sum = arr[si] + arr[ei];
            if(sum  == target){
                List<Integer> smallAns = new ArrayList<>();
                smallAns.add(arr[si]);
                smallAns.add(arr[ei]);
                ans.add(smallAns);
                si++;
                ei--;
                while(si < ei && arr[si - 1] == arr[si])si++;
                while(si < ei && arr[ei + 1] == arr[ei])ei--;
            }
            else if(sum < target){
                si++;
            }
            else{
                ei--;
            }
        }
        return ans;
        
    }
    public List<List<Integer>> threeSum(int[] nums,int target,int si) {
        int a = 0,b = 0,c = 0;
        //target = 0;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = si;i < nums.length;){
            
            List<List<Integer>> smallAns = twoSum(nums,target - nums[i],i + 1,nums.length - 1);
            for(int j = 0;j < smallAns.size(); j++){
                smallAns.get(j).add(nums[i]);
                ans.add(smallAns.get(j));
             }
                i++;
                while(i < nums.length && nums[i - 1] == nums[i]) i++;
            
        }
        return ans;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
         for(int i = 0;i < nums.length;){
            List<List<Integer>> smallAns = threeSum(nums,target - nums[i],i + 1);
            for(int j = 0;j < smallAns.size(); j++){
                smallAns.get(j).add(nums[i]);
                ans.add(smallAns.get(j));
             }
                i++;
                while(i < nums.length && nums[i - 1] == nums[i]) i++;
            
        }
        return ans;
    }
}