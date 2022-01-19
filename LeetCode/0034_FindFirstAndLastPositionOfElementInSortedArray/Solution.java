class Solution {
  public int[] searchRange(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) {
      return new int[] { -1, -1 };

    }
    if (n == 1) {
      if (nums[0] == target) {
        return new int[] { 0, 0 };
      } else {
        return new int[] { -1, -1 };
      }
    }
    int[] ret = new int[2];
    int l = -1, r = n;
    int m;
    while (r - l > 1) {
      m = (r - l) / 2 + l;
      if (target <= nums[m]) {
        r = m;
      } else {
        l = m;
      }
    }
    if (r >= n || nums[r] != target) {
      return new int[] { -1, -1 };

    }
    ret[0] = r;

    l = -1;
    r = n;
    while (r - l > 1) {
      m = (r - l) / 2 + l;
      if (target < nums[m]) {
        r = m;
      } else {
        l = m;
      }
    }
    ret[1] = l;
    return ret;

  }
}
