class Solution {
  public List<Integer> partitionLabels(String s) {
    int len = s.length();
    int[] memo = new int[s.length()];
    for (int l = 0; l < len; l++) {
      int r = len - 1;
      while (l <= r) {
        if (s.charAt(r) == s.charAt(l)) {
          memo[l] = r;
          break;
        }
      }
    }
    List<Integer> ret = new LinkedList<>();
    int start = 0;
    while (start < len) {
      int l = start;
      int r = memo[l];
      while (l <= r) {
        if (r < memo[l]) {
          r = memo[l];
        }
        l++;
      }
      ret.add(r - start + 1);
      start = r + 1;
    }
    return ret;

  }

}
