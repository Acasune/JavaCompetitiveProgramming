import java.util.Arrays;

class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] ans = new int[nums.length];
    int cntZero = Arrays.stream(nums).filter(e -> e == 0).count();
    if (cntZero >= 2) {
      return ans;
    }

    int product = Arrays.stream(nums).filter(e -> e != 0).reduce(0, (a, b) -> a * b);
    for (int i = 0; i < nums.length; i++) {
      if (cntZero == 1) {
        if (nums[i] == 0) {
          ans[i] = 0;
        } else {
          ans[i] = product;
        }
      } else {
        ans[i] = product / nums[i];
      }
    }
    return ans;

  }
}
