class Solution {
    public String reverseWords(String s) {
        
        String[] arr = s.split(" ");
        String ans = "";
        
        for(int i = 0;i < arr.length;i++)
        {
            StringBuilder sb = new StringBuilder(arr[i]);
            ans += sb.reverse().toString();
            ans += " ";
            
        }
        return ans.trim();
    }
}