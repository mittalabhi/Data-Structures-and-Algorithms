class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sp = 0;
        int extraGas = 0;
        int deficit = 0;
        for(int i = 0;i < gas.length; i++){
            extraGas += gas[i] - cost[i];
            if(extraGas < 0){
                deficit += extraGas;
                extraGas = 0;
                sp = i + 1;
            }
        }
        return extraGas + deficit >= 0 ? sp : -1;
    }
}