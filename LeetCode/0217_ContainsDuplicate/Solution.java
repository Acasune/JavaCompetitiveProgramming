class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (var e : nums) {
      if (set.contains(e)) {
        return true;
      }
      set.add(e);
    }
    return false;
  }
}
