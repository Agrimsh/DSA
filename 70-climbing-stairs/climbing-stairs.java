/*class Solution {
    public int climbStairs(int n) {
        int []arr=new int[n+1];
        return help(n,arr);
    }
    public static int help(int n,int arr[]){
        if(n<0){
            return 0;
        }
        if(n==0)
            return 1;
        if(arr[n]==0){
        arr[n]=help(n-1, arr) + help(n-2,arr); 
        }  
        return arr[n];
    }
}*/

class Solution {
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}

/* class Solution {
    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        int ans= climbStairs(n-1)+climbStairs(n-2);
        return ans;
    }
}

class Solution {
    public int climbStairs(int n) {
        if(n<2){
            return n;
        }
       int a=1;
        int b=2;
        for(int i=3;i<n;i++){
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
        
    }
}*/