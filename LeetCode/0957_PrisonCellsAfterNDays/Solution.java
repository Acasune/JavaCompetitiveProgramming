import java.util.Map;

class Solution {
  public int[] prisonAfterNDays(int[] cells, int n) {
    int[] states = new int[1 << 7];
    Map<Integer, Integer> mp = new HashMap<>();
    int curState = toMask(cells);
    int nextState = 0, iter = 0, repeatedIndex = -1;
    mp.put(curState, 0);
    states[iter++] = curState;
    while (true) {
      nextState = 0;
      int l = 0, r = 1;
      for (int i = 1; i < 7; i++) {
        l = (curState & (1 << (i + 1))) >> (i + 1);
        r = (curState & (1 << (i - 1))) >> (i - 1);
        nextState |= ((1 ^ l ^ r) << i);
      }
      if (mp.get(nextState) != null) {
        repeatedIndex = mp.get(nextState);
        break;
      }
      mp.put(nextState, iter);
      states[iter++] = nextState;
      curState = nextState;
      if (iter == n + 1) {
        return toArray(states[iter - 1]);
      }
    }
    int interval = iter - repeatedIndex;
    int targetIndex = (n - iter) % interval;
    return toArray(states[targetIndex + iter - interval]);

  }

  static int toMask(int[] cells) {
    int mask = 0;
    for (int i = 7; 0 <= i; i--) {
      mask |= (cells[7 - i] << i);
    }
    return mask;
  }

  static int[] toArray(int mask) {
    int[] ret = new int[8];
    int i = 7;

    while (mask > 0 && i > 0) {
      ret[i--] = mask & 1;
      mask >>= 1;
    }

    return ret;
  }
}
