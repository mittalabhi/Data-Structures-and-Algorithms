class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> st = new Stack<>();
        for(int i = 0;i < intervals.length;i++){
            if(st.size() != 0 && intervals[i][0] >= st.peek()[0] && intervals[i][0] <= st.peek()[1]){
                int arr[] = st.pop();
                arr[0] = arr[0];
                if(intervals[i][1] > arr[1])
                    arr[1] = intervals[i][1];
                st.push(arr);
            }
            else{
                st.push(new int[]{intervals[i][0],intervals[i][1]});
            }

        }
        int size = st.size();
        int ans[][] = new int[size][2];
        int i = st.size()-1;
        while(st.size() != 0){
            int arr[] = st.pop();
            ans[i][0] = arr[0];
            ans[i][1] = arr[1];
            i--;
        }
        return ans;

    }
}
