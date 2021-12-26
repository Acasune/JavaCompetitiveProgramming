import java.util.Stack;

class Solution {
  public int sumSubarrayMins(int[] arr) {
    int mod = (int) 1e9 + 7;
    int ret = 0;
    int[] dp = new int[arr.length + 1];
    Stack<Integer> stk = new Stack<>();
    stk.push(-1);
    for (int i = 0; i < arr.length; i++) {
      while (stk.peek() != -1 && arr[stk.peek()] > arr[i]) {
        stk.pop();
      }
      dp[i + 1] = (arr[i] * (i - stk.peek()) + dp[stk.peek() + 1]) % mod;
      stk.push(i);
      ret += dp[i + 1];
      ret %= mod;

    }
    return ret;
  }
}
