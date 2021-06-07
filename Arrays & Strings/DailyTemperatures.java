class Solution {
    public int[] dailyTemperatures(int[] T) {
        int res[] = new int[T.length];
        Stack<Integer> s1 = new Stack<>();
        for(int i = 0; i < T.length; i++) {
        
            while(!s1.isEmpty() && T[s1.peek()] < T[i]){
                int temp = s1.peek();
                s1.pop();
                res[temp] = i - temp;
            }
            s1.push(i);
        }
        return res;
    }
}