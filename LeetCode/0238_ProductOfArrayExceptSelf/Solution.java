import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] ans = new int[nums.length];
    long cntZero = Arrays.stream(nums).filter(e -> e == 0).count();
    if (cntZero >= 2) {
      return ans;
    }

    long product = Arrays.stream(nums).filter(e -> e != 0).reduce(1, (a, b) -> a * b);
    for (int i = 0; i < nums.length; i++) {
      if (cntZero == 1) {
        if (nums[i] != 0) {
          ans[i] = 0;
        } else {
          ans[i] = (int) product;
        }
      } else {
        ans[i] = (int) (product / nums[i]);
      }
    }
    return ans;

  }
}
