class Solution {
  public boolean canJump(int[] nums) {
    int n = nums.length;
    int[] memo = new int[n];
    Arrays.fill(memo, 100_000_000);
    memo[0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= nums[i]; j++) {
        if (i + j >= n) {
          break;
        }
        memo[i + j] = Math.min(memo[i + j], memo[i] + 1);
      }
    }

    return memo[n - 1] != 100_000_000;

  }
}
