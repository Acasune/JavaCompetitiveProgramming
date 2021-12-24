import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FreqStack {
  List<ArrayDeque<Integer>> vals;
  Map<Integer, Integer> mp;

  public FreqStack() {
    vals = new ArrayList<>();
    mp = new HashMap<>();
  }

  public void push(int val) {
    mp.put(val, mp.getOrDefault(val, 0) + 1);
    int freq = mp.get(val) - 1;
    if (freq >= vals.size()) {
      vals.add(new ArrayDeque<>());
    }
    vals.get(freq).addLast(val);
  }

  public int pop() {
    int freq = vals.size() - 1;
    int x = vals.get(freq).pollLast();
    if (vals.get(freq).isEmpty()) {
      vals.remove(vals.size() - 1);
    }
    mp.put(x, mp.get(x) - 1);
    if (mp.get(x) == 0) {
      mp.remove(x);
    }
    return x;
  }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
