class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int map[] = new int[128];
        for(int i = 0;i < allowed.length(); i++){
            map[allowed.charAt(i)]++;
        }
        int count = 0;
        for(int i = 0;i < words.length; i++){
            String str = words[i];
            count++;
            for(int j = 0;j < str.length(); j++){
                if(map[str.charAt(j)] == 0) {
                    count--;
                    break;
                }
            }


        }
        return count;
    }
}