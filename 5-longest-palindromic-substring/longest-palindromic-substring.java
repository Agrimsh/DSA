class Solution {

    public String longestPalindrome(String s) {

        if(s == null || s.length() <= 1)
            return s;

        int start = 0;
        int maxLen = 1;

        for(int i = 0; i < s.length(); i++) {

            int odd = expand(i, i, s);
            int even = expand(i, i + 1, s);

            int len = Math.max(odd, even);

            if(len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    public int expand(int left, int right, String s) {

        while(left >= 0 &&
              right < s.length() &&
              s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}