class RecursionBasics{
    public void printIncreasing(int a,int b){
        if(a >= b) return;
        System.out.print(a);
        printIncreasing(a + 1 ,b);
    
    }
    public void printDecreasing(int a,int b){
        if(a >= b) return;
        printIncreasing(a + 1 ,b);
        System.out.print(a);
    
    }
    public void printIncDec(int n){
        System.out.print(n);
        printIncDec(n - 1);
        System.out.print(n);
    }
    public int pow(int a,int b){
        if(b == 0) return 1;
        int smallAns = pow(a,b / 2);
        return smallAns * smallAns;
    }
    public void displayArray(int arr[],int idx){
        if(idx == arr.length) return;
        System.out.print(arr[idx]);
        displayArray(arr,idx+1);
    }
    public int maxArray(int arr[],int idx){
        if(idx == arr.length) return -(int)1e9;
        int max = maxArray(arr,idx+1);
        return Math.max(max,arr[idx]);

    }
    public int minArray(int arr[],int idx){
        if(idx == arr.length) return (int)1e9;
        int max = minArray(arr,idx+1);
        return Math.min(max,arr[0]);

    }
    public boolean findArray(int arr[],int ele,int idx){
        if(idx == arr.length) return false;
        boolean ans = findArray(arr,ele,idx + 1);
        return ans || (arr[idx] == ele);
    }
    public int firstIdx(int arr[],int ele,int idx){
        if(idx == arr.length) return -1;
        if(arr[idx] == ele) return idx;
        return firstIdx(arr,ele,idx + 1);
    }
    public int lastIdx(int arr[],int ele,int idx){
        if(idx == arr.length) return -1;
        int search = lastIdx(arr,ele,idx + 1);
        if(search != -1) return search;
        return arr[idx] == ele ? idx : -1;
    }
    public static int count = 0;
    public static int[] findAll(int arr[],int ele,int idx){
        if(idx == arr.length){
            int nums[] = new int[count];
            return nums;
        }
        if(arr[idx] == ele) count++;
        int [] smallAns = findAll(arr,ele,idx + 1);
        if(arr[idx] == ele){
            smallAns[--count] = idx;    
        }
        return smallAns;
    }
    public static int count2 = 0;
    public static void main(String []args){
        int arr[] = {1,2,1,2,2,2,2,4,4,2,2};
        int ans[] = findAll(arr,2,0);
        
        subsequence("mittal",0,"");
        System.out.print(count2);
    }
    public static void subsequence(String str,int idx,String ans){
        if(idx == str.length()){
            System.out.print(ans + " ");
            System.out.println();
            count2++;
            return;
        }
        char ch = str.charAt(idx);
        subsequence(str,idx + 1,ans + ch);
        subsequence(str,idx + 1,ans);
    }
}