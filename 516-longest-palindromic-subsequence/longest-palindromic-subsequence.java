class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return helper(s,0,s.length()-1,dp);  
    }
    public int helper(String s, int i,int j,int dp[][]){
        int take=0;
        if(i==j){
            return 1; // a single char is always palindrome
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            take=2+helper(s,i+1,j-1,dp);
        }
        int not_take=Math.max(helper(s,i+1,j,dp),helper(s,i,j-1,dp));
        return dp[i][j]=Math.max(take,not_take);
    }
}