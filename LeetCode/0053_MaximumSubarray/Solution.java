class Solution {
  public int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int[] cumsum = new int[nums.length + 1];
    cumsum[0] = 0;
    for (int i = 0; i < nums.length; i++) {
      cumsum[i + 1] = cumsum[i] + nums[i];
    }
    int ret = -1000000;
    for (int r = 1; r < cumsum.length; r++) {
      for (int l = 0; l < r; l++) {
        ret = Integer.max(cumsum[r] - cumsum[l], ret);

      }
    }
    return ret;

  }
}
