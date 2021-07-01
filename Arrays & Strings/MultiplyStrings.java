class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        
        int[] res = new int[l1 + l2];
        
        int i = l2 - 1;
        int pf = 0; //powerfactor
        while(i >= 0)
        {
            int ival = num2.charAt(i) - '0';
            i--;
            int j = l1 - 1;
            int k = l1 + l2 - 1 - pf;
            int carry = 0;
            
            while(j >= 0 || carry != 0)
            {
                int jval = j >= 0 ? num1.charAt(j) - '0' : 0;
                j--;
                
                int prod = res[k] + ival* jval + carry;
                res[k] = prod % 10;
                carry = prod / 10;
                k--;
                
            }
            pf++;
        }
        
        boolean flag = false;
        String ans = "";
        for(int v = 0;v < res.length;v++){
            if(res[v] == 0 && flag == false) continue;
            else
            {
                flag = true;
                ans += res[v];
            }
        }
        return ans;
    }
}