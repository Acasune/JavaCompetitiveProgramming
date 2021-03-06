class Solution {
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 0; i <= target; i++) {
      for (var a : nums) {
        if (i + a > target)
          continue;
        dp[i + a] += dp[i];
      }
    }
    return dp[target];

  }
}
