class Solution {
  public int longestArithSeqLength(int[] nums) {
    int n = nums.length;
    if (n == 2) {
      return 2;
    }
    int prev = -1;
    int ret = -1;
    int diff = -1;
    int cnt = -1;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        diff = nums[i] - nums[j];
        prev = nums[j];
        cnt = 2;
        for (int k = j + 1; k < n; k++) {
          if (prev - nums[k] == diff) {
            cnt++;
            prev = nums[k];
          }
        }
        ret = Math.max(ret, cnt);
      }
    }
    return ret;
  }
}
