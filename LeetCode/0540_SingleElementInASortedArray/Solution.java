class Solution {
  public int singleNonDuplicate(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    if (nums[0] != nums[1] && nums[1] == nums[2]) {
      return nums[0];
    }
    if (nums[n - 1] != nums[n - 2] && nums[n - 2] == nums[n - 3]) {
      return nums[n - 1];
    }
    int l = 0, r = n, m;
    while (r - l > 1) {
      m = (r + l) / 2;
      if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
        return nums[m];
      }
      if (((n - m) % 2 == 0) && (nums[m - 1] == nums[m]) || ((n - m) % 2 == 1) && (nums[m] == nums[m + 1])) {
        l = m;
      } else {
        r = m;
      }
    }
    return nums[l];
  }
}
