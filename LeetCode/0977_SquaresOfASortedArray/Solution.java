class Solution {
  public int[] sortedSquares(int[] nums) {
    int left = 0, right = nums.length - 1;
    int idx = nums.length - 1;
    int[] ans = new int[nums.length];
    while (left <= right) {
      if (nums[left] * nums[left] < nums[right] * nums[right]) {
        ans[idx--] = nums[right] * nums[right];
        right--;
      } else {
        ans[idx--] = nums[left] * nums[left];
        left++;
      }
    }
    return ans;
  }
}
