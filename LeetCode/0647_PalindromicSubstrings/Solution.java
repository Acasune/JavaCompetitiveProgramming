class Solution {
  public int countSubstrings(String s) {
    char[] cs = s.toCharArray();
    int ret = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      int l = i - 1;
      int r = i + 1;
      ret++;
      while (0 <= l && r < n) {
        if (cs[l] == cs[r]) {
          ret++;
          l--;
          r++;
        } else {
          break;
        }
      }
      l = i;
      r = i + 1;
      while (0 <= l && r < n) {
        if (cs[l] == cs[r]) {
          ret++;
          l--;
          r++;
        } else {
          break;
        }
      }
    }
    return ret;

  }
}
