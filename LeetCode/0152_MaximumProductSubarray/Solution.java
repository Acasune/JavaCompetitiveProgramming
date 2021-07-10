class Solution {
  public int maxProduct(int[] nums) {
    int maxSoFar = nums[0];
    int minSoFar = nums[0];
    int res = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int tmpMax = maxSoFar;
      maxSoFar = Integer.max(nums[i], Integer.max(nums[i] * maxSoFar, nums[i] * minSoFar));
      minSoFar = Integer.min(nums[i], Integer.min(nums[i] * tmpMax, nums[i] * minSoFar));
      res = Integer.max(res, maxSoFar);

    }
    return res;
  }
}
