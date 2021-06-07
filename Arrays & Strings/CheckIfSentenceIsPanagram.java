class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> hm = new HashSet<>();
        for(int i = 0;i < sentence.length(); i++){
            char ch = sentence.charAt(i);
            hm.add(ch);
        }
        return hm.size() == 26 ? true : false;
    }
}
