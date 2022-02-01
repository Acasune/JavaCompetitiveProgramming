import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ret = new LinkedList<>();
    Set<Integer> st = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toSet()));

    for (int i = 1; i < nums.length + 1; i++) {
      if (!st.contains(i)) {
        ret.add(i);
      }
    }
    return ret;
  }
}
