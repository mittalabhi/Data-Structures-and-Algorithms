class Solution {

    public int romanToInt(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int ans = 0;
        for(int i = 0;i < s.length(); i++){
            char ch = s.charAt(i);
            int val = hm.get(ch);
            System.out.println(ans);
            if(i > 0 && hm.get(s.charAt(i - 1)) < val ){
                int beforeAns = hm.get(s.charAt(i - 1));
                val -= 2 * beforeAns;
            }
            ans += val;

        }
        return ans;
    }
}