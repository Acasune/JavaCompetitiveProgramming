class Solution {
  public int findMin(int[] nums) {

    int l = 0;
    int r = nums.length - 1;
    int m = -1;

    while (r - 1 > l) {
      m = (r + l) / 2;
      if (nums[r] > nums[m]) {
        // if m is too large
        r = m;
      } else {
        l = m;
      }

    }
    return Integer.min(nums[0], nums[r]);

  }
}
