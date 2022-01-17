import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Map<Integer, Set<List<Integer>>> mp = new HashMap<>();
    Arrays.sort(candidates);
    for (int i = 0; i < candidates.length; i++) {
      int val = candidates[i];
      for (int j = target; 0 < j; j--) {
        if (mp.containsKey(j)) {
          for (var tmp : mp.get(j)) {
            List<Integer> tmp2 = new LinkedList<>(tmp);
            tmp2.add(val);
            mp.putIfAbsent(j + val, new HashSet<>());
            mp.get(j + val).add(tmp2);
          }
        }
      }
      mp.putIfAbsent(val, new HashSet<>());
      List<Integer> tmp = new LinkedList<>();
      tmp.add(val);
      mp.get(val).add(tmp);
    }
    if (mp.containsKey(target)) {
      return new LinkedList<>(mp.get(target));
    } else {
      return new LinkedList<>();
    }

  }

}
