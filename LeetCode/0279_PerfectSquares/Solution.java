import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 1_000_000_000);
    List<Integer> squares = new LinkedList<>();
    for (int i = 1; i * i <= n; i++) {
      squares.add(i * i);
    }
    dp[0] = 0;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j < squares.size(); j++) {
        int num = squares.get(j);
        if (i + num > n)
          continue;
        dp[i + num] = Math.min(dp[i + num], dp[i] + 1);
      }
    }
    return dp[n];
  }
}
