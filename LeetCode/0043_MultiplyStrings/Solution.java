import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int trap(int[] height) {
    Deque<Integer> posDeq = new ArrayDeque<>();

    int ret = 0, i = 0;
    while (i < height.length) {
      if (posDeq.isEmpty() || height[i] <= height[posDeq.peekLast()]) {
        posDeq.addLast(i);
        i += 1;
      } else {
        int bot = posDeq.pollLast();
        int tmp = posDeq.isEmpty() ? 0
            : (Math.min(height[posDeq.peekLast()], height[i]) - height[bot]) * (i - posDeq.peekLast() - 1);
        ret += tmp;
      }
    }
    return ret;
  }
}
