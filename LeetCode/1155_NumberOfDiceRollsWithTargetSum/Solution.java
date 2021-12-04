class Solution {
  public int numRollsToTarget(int d, int f, int target) {
    if (d * f < target) {
      return 0;
    }
    int maxValue = d * f + 5;
    int mod = 1_000_000_000 + 7;
    int[][] memo = new int[maxValue][d];
    for (int i = 1; i < f + 1; i++) {
      memo[i][0] = 1;
    }
    for (int i = 1; i < d; i++) {
      for (int j = 1; j < maxValue; j++) {
        for (int k = 1; k <= f; k++) {
          if (j + k > d * f)
            break;
          memo[j + k][i] += memo[j][i - 1];
          memo[j + k][i] %= mod;
        }

      }
    }

    return memo[target][d - 1] % mod;
  }
}
