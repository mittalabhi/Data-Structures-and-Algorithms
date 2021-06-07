class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i : arr){
            if(hs.contains(2 * i) || (i % 2 == 0 && hs.contains(i / 2)))
                return true;
            else
                hs.add(i);
        }
        return false;
    }
}