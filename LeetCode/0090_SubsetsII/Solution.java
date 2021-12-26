import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    Set<List<Integer>> ret = new HashSet<>();
    for (int i = 0; i < (1 << n); i++) {
      List<Integer> lst = new LinkedList<>();
      for (int j = 0; j < n; j++) {
        if (((i >> j) & 1) != 0) {
          lst.add(nums[j]);
        }
        ret.add(lst);
      }
    }
    return new ArrayList<>(ret);
  }
}
