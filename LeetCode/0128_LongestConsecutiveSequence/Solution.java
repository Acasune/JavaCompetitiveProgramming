import java.util.HashMap;
import java.util.Map;

class Solution {
  public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> mp = new HashMap<>();
    int ret = 0;
    for (var a : nums) {
      if (!mp.containsKey(a)) {
        int l = mp.getOrDefault(a - 1, 0);
        int r = mp.getOrDefault(a + 1, 0);

        int sum = r + l + 1;
        mp.put(a, sum);
        ret = Integer.max(ret, sum);

        mp.put(a - l, sum);
        mp.put(a + r, sum);

      }

    }
    return ret;

  }

}
