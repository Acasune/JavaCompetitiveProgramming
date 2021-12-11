class Solution {
  public void moveZeroes(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      if (nums[left] == 0) {
        int tmpIdx = left;
        while (tmpIdx < right) {
          int tmp = nums[tmpIdx];
          nums[tmpIdx] = nums[tmpIdx + 1];
          nums[tmpIdx + 1] = tmp;
          tmpIdx++;
        }
        right--;
        continue;
      }
      left++;
    }

  }

}
