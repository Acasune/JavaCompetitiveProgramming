import java.util.Arrays;

class Solution {
  public int thirdMax(int[] nums) {
    nums = Arrays.stream(nums).distinct().sorted().toArray();
    if (nums.length < 3) {
      return nums[nums.length - 1];
    }
    return nums[nums.length - 3];
  }
}
