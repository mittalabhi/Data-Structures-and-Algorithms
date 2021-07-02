class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        
        while(lo <= hi){
            mid = (lo + hi) / 2;
            if(arr[mid] == x)
                break;
            else if(x > arr[mid]){
                lo = mid + 1;
            }
            else
                hi = mid - 1;
            
        }
        System.out.print(lo + " " + hi);
        int l = Math.max(0,mid - 1);
        int r = l + 1;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(l >= 0 && r < arr.length && k > 0){
            if(Math.abs(x - arr[l]) <= Math.abs(x - arr[r]))
            {
                list.add(arr[l]);
                l--;
            }
            else{
                list.add(arr[r]);
                r++;
            }
            k--;
        }
        while( k > 0 && l >=0){
            list.add(arr[l]);
            l--;
            k--;
        }
        while(k > 0 && r < arr.length){
            list.add(arr[r]);
            r++;
            k--;
        }
        Collections.sort(list);
        return list;
    }
}