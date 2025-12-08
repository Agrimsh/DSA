class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, s, n,dp);
    }

    public int solve(int idx, String s, int n,int dp[]) {

        if (idx == n) {  // index reached end of string
            return 1;
        }

        if (s.charAt(idx) == '0') {  // if character is '0', no decoding
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }


        int result = solve(idx + 1, s, n,dp);  // take one character

        // check if two-character decoding is possible
        if (idx + 1 < n) {//out of bound
            if (s.charAt(idx)== '1' || (s.charAt(idx) == '2' && s.charAt(idx+1) <= '6')) {
                result += solve(idx + 2, s, n,dp);
            }
        }

         dp[idx]=result;
         return result;
    }
}
