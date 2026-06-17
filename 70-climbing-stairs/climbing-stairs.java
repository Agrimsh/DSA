class Solution {
    public int climbStairs(int n) {
        if(n<=1){
            return 1;
        }
        int a = 1; // F(0)
        int b = 1; // F(1)
         

        for(int i = 2; i <= n; i++) {
            int c = a + b; // F(i) = F(i-1) + F(i-2)
            a = b;     // shift a to previous
            b = c;     // shift b to current
        }
        return b;
    }
}