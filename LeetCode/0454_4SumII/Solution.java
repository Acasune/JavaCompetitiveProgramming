import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

class Solution {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    int n = nums1.length;
    Map<Integer, Integer> mp1 = new HashMap<>();
    Map<Integer, Integer> mp2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int tmp = nums1[i] + nums2[j];
        mp1.put(tmp, mp1.getOrDefault(tmp, 0) + 1);
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int tmp = nums3[i] + nums4[j];
        mp2.put(-tmp, mp2.getOrDefault(-tmp, 0) + 1);
      }
    }
    int ret = 0;
    for (var entry : mp1.entrySet()) {
      int key = entry.getKey();
      int val = entry.getValue();

      if (mp2.containsKey(key)) {
        ret += val * mp2.get(key);
      }

    }
    return ret;

  }
}
