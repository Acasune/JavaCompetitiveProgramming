class Solution {
  public int maxProfit(int[] prices) {
    int l = prices.length;
    int[] left = new int[l], right = new int[l];
    left[0] = prices[0];
    right[l - 1] = prices[l - 1];
    for (int i = 1; i < l; i++) {
      left[i] = Integer.min(left[i - 1], prices[i]);
    }
    for (int i = l - 2; 0 <= i; i--) {
      right[i] = Integer.max(right[i + 1], prices[i]);
    }

    int ret = 0;
    for (int i = 0; i < l - 1; i++) {
      ret = Integer.max(ret, right[i + 1] - left[i]);
    }
    return ret;

  }
}
