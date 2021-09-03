class Solution {
    public int[] decode(int[] encoded, int first) {
        int ans[] = new int[encoded.length + 1];
        int j = 0;
        ans[0] = first;
        for(int i = 0;i < encoded.length;i++){
            int res = encoded[i];
            int one = ans[j++];
            ans[j] = one ^ res;
        }
        return ans;
    }
}