import java.util.Map;

class Solution {
  private int solve(int[] nums, int k) {
    int sum = 0, ans = 0;
    int l = 0, r = 0;
    int[] cnt = new int[2 * 1_0000 + 5];
    for (; r < nums.length; r++) {
      if (cnt[nums[r]] == 0) {
        sum++;
      }
      cnt[nums[r]]++;
      while (l < nums.length && sum > k) {
        cnt[nums[l]]--;
        if (cnt[nums[l]] == 0) {
          sum--;
        }
        l++;
      }
      ans += r - l + 1;

    }

    return ans;

  }

  public int subarraysWithKDistinct(int[] nums, int k) {
    return solve(nums, k) - solve(nums, k - 1);
  }

}
