import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int clumsy(int n) {
    Deque<Integer> deq1 = new ArrayDeque<>();
    Deque<Integer> deq2 = new ArrayDeque<>();
    int sign = 0;
    deq1.addLast(n);
    n--;
    while (n > 0) {
      if (sign == 0) {
        int a = deq1.pollLast();
        deq1.addLast(a * n);
      } else if (sign == 1) {
        int a = deq1.pollLast();
        deq1.addLast(a / n);
      } else if (sign == 2) {
        deq1.addLast(n);
        deq2.addLast(1);
      } else if (sign == 3) {
        deq1.addLast(n);
        deq2.addLast(-1);
      }
      sign = (sign + 1) % 4;
      n--;
    }
    int ret = deq1.pollFirst();
    while (!deq1.isEmpty()) {
      ret = ret + deq2.pollFirst() * deq1.pollFirst();
    }
    return ret;
  }
}
