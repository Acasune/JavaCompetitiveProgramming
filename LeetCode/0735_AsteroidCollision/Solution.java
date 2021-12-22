import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
  public int[] asteroidCollision(int[] asteroids) {

    int n = asteroids.length;
    Deque<Integer> deq = new ArrayDeque<>();
    deq.addLast(-1);
    for (int i = 0; i < n; i++) {
      int ast = asteroids[i];
      if (ast > 0) {
        deq.addLast(ast);
      } else if (ast == 0) {
        if (deq.peekLast() <= 0) {
          deq.add(ast);
        }
      } else {
        while (!deq.isEmpty()) {
          int tmp = deq.pollLast();
          if (tmp < 0) {
            deq.add(tmp);
            deq.add(ast);
            break;
          }
          if (tmp >= -ast) {
            if (tmp != -ast) {
              deq.addLast(tmp);
            }
            break;
          }
        }
      }
    }
    deq.pollFirst();
    return deq.stream().mapToInt(i -> i).toArray();

  }
}
