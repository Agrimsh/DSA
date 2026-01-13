class Solution {
    int[][] dp;

    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a, b) -> a.length() - b.length());
        dp = new int[words.length][words.length + 1];
        for (int[] r : dp) Arrays.fill(r, -1);
        return helper(words, 0, -1);
    }

    public int helper(String[] words, int i, int prev) {
        if(i == words.length){
            return 0;
        }

        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];
        int not_take = helper(words, i + 1, prev);
        int take = 0;
        if (prev == -1 || ispredecessor(words[i], words[prev])) {
            take = 1 + helper(words, i + 1, i);
        }
        return dp[i][prev + 1] = Math.max(take, not_take);
    }

    boolean ispredecessor(String a, String b) {
        if (a.length()!= b.length() + 1) return false;

        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == b.length();
    }
}
