class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    int sum = Arrays.stream(nums).sum();
    if ((target + sum) % 2 != 0 || sum < Math.abs(target)) {
      return 0;
    }
    int t = (target + sum) / 2;
    int[] memo = new int[t + 1];
    memo[0] = 1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = t; j >= nums[i]; j--) {
        memo[j] += memo[j - nums[i]];
      }
    }

    return memo[t];
  }
}
