class Solution {

    public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(words, 0, -1, dp);
    }

    boolean isPredecessor(String small, String large) {

        if (large.length() != small.length() + 1)
            return false;

        int i = 0, j = 0;

        while (i < small.length() && j < large.length()) {

            if (small.charAt(i) == large.charAt(j))
                i++;

            j++;
        }

        return i == small.length();
    }

    int helper(String[] words, int i, int prev, int[][] dp) {

        if (i == words.length)
            return 0;

        if (dp[prev + 1][i] != -1)
            return dp[prev + 1][i];

        int take = 0;

        if (prev == -1 || isPredecessor(words[prev], words[i])) {
            take = 1 + helper(words, i + 1, i, dp);
        }

        int notTake = helper(words, i + 1, prev, dp);

        return dp[prev + 1][i] = Math.max(take, notTake);
    }
}