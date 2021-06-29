class Solution {
    class Pair{
        char ch;
        int c;
        Pair(char ch,int c){
            this.ch = ch;
            this.c = c;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char ch1 = s.charAt(i);
            if(st.size() == 0 || st.peek().ch != ch1){
                st.push(new Pair(ch1,0));
            }
            st.peek().c++;
            if(st.peek().c == k){
                st.pop();
            }
        }
    
    StringBuilder str = new StringBuilder();
        System.out.print(st.size());
    while(!st.isEmpty()){
        int size = st.peek().c;
        while(size != 0){
        str.append(st.peek().ch);
            size --;
        }
        st.pop();
    }
    return str.reverse().toString();
}
}