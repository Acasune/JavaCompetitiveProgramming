class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int n = nums.length;
    double[] cumsum = new double[n + 1];
    for (int i = 1; i < n + 1; i++) {
      cumsum[i] = cumsum[i - 1] + nums[i - 1];
    }
    double maxSum = -1000000000.0;
    for (int i = k; i < n + 1; i++) {
      maxSum = Math.max(maxSum, cumsum[i] - cumsum[i - k]);
    }
    return maxSum / k;

  }
}
