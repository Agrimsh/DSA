class Solution {
    public int fib(int n) {
        int arr[]=new int[n+1]; 
        return help(n,arr);
    }
    public int help(int n,int arr[]){
        if(n<2){
            return n;
        }
        if(arr[n]==0){
            arr[n]=help(n-1,arr)+help(n-2,arr);
        }
        return arr[n];
    }
}