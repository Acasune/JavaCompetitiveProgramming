class Solution {
  public int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if ('0' < c && c <= '9') {
        dp[i + 1] += dp[i];
      }

      if (i != 0) {
        if (10 <= Integer.valueOf(s.substring(i - 1, i + 1)) && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) {
          dp[i + 1] += dp[i - 1];
        }

      }
    }
    return dp[s.length()];

  }
}
