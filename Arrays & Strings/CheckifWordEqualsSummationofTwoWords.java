class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sum1 = 0;
        int targetSum = 0;
        int sum2 = 0;
        for(int i = 0;i < firstWord.length(); i++){
            char ch = firstWord.charAt(i);
            sum1 = sum1 * 10 + (ch - 'a');
        }
        for(int i = 0;i < secondWord.length(); i++){
            char ch = secondWord.charAt(i);
            sum2 = sum2 * 10 + (ch - 'a');
        }
        for(int i = 0;i < targetWord.length(); i++){
            char ch = targetWord.charAt(i);
            targetSum = targetSum * 10 + (ch - 'a');
        }

        return sum1 + sum2 == targetSum ? true : false;
    }
}