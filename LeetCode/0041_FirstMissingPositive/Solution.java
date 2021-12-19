class Solution {
  public int firstMissingPositive(int[] nums) {
    boolean hasOne = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        hasOne = true;
      }
      if (nums[i] <= 0 || nums[i] > nums.length) {
        nums[i] = 1;
      }
    }
    if (!hasOne) {
      return 1;
    }
    for (int i = 0; i < nums.length; i++) {
      if (Math.abs(nums[i]) == 1)
        continue;
      int idx = Math.abs(nums[i]) - 1;
      nums[idx] = -Math.abs(nums[idx]);
    }
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }
}
