class Solution {
    public int noOfOnes(int n)
    {
        int count = 0;
        while(n != 0)
        {
            if(n % 2 != 0)count++;
            n = n / 2;
        }
        return count;
    }
    public int[] countBits(int n) {
        int arr[] = new int[n + 1];
        for(int i = 0;i < arr.length;i++)
        {
            arr[i] = noOfOnes(i);
        }
        return arr;
    }
}