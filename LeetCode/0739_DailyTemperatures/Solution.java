import java.util.ArrayDeque;

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] ret = new int[n];
    ArrayDeque<Integer> deq = new ArrayDeque<>();
    deq.push(0);
    for (int i = 1; i < n; i++) {
      int num = temperatures[i];
      while (!deq.isEmpty() && num > temperatures[deq.peekLast()]) {
        int j = deq.pollLast();
        ret[j] = i - j;
      }
      deq.offerLast(i);
    }
    return ret;
  }
}
