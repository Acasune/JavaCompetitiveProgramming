class Solution {
  public int[] sortArrayByParity(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      while (nums[l] % 2 == 0 && l < r) {
        l++;
      }
      while (nums[r] % 2 != 0 && l < r) {
        r--;
      }
      if (l == r) {
        break;
      }
      int tmp = nums[r];
      nums[r] = nums[l];
      nums[l] = tmp;
      l++;
      r--;
    }
    return nums;
  }
}
