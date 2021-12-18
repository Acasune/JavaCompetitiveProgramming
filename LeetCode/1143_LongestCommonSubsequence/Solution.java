class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int n1 = text1.length(), n2 = text2.length();
    int[][] dp = new int[n1][n2];
    if (text1.charAt(0) == text2.charAt(0)) {
      dp[0][0] = 1;
    }
    for (int i = 1; i < n1; i++) {
      if (text1.charAt(i) == text2.charAt(0)) {
        dp[i][0] = Integer.max(dp[i - 1][0], 1);
      } else {
        dp[i][0] = dp[i - 1][0];
      }
    }
    for (int j = 1; j < n2; j++) {
      if (text1.charAt(0) == text2.charAt(j)) {
        dp[0][j] = Integer.max(dp[0][j - 1], 1);
      } else {
        dp[0][j] = dp[0][j - 1];
      }
    }
    for (int i = 1; i < n1; i++) {
      for (int j = 1; j < n2; j++) {
        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j - 1] + 1);
          dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j]);
        } else {
          dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    return dp[n1 - 1][n2 - 1];
  }
}
