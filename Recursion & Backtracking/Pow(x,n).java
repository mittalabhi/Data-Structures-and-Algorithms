class Solution {
    public double myPowPos(double x, int n) {
        if(n == 1 || n == 0){
            if(n == 1)return x;
            if(n == 0)return 1;
        }
        double smallAns = myPowPos(x,n  / 2);
        smallAns *= smallAns;
        return n % 2 == 0 ? smallAns : smallAns * x;
    }
    public double myPowNeg(double x,int n){
        if(n == -1 || n == 0){
          if(n == -1)return 1 / x;
          if(n == 0)return 1;
        } 
        double smallAns = myPowNeg(x,n / 2);
        smallAns *= smallAns;
        return n % 2 == 0 ? smallAns : smallAns * 1/x;
    }
    public double myPow(double x, int n) {
        if(n >= 0) return myPowPos(x,n);
        else{
            return myPowNeg(x,n);
        }
    }
}
