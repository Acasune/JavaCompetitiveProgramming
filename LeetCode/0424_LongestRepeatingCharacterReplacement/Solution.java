class Solution {
  public int characterReplacement(String s, int k) {
    char[] cs = s.toCharArray();
    int ret = -1;
    int n = s.length();
    for (char c = 'A'; c <= 'Z'; c++) {
      int l = -1;
      int r = 0;
      int cntNotTarget = 0;
      while (r < n) {
        if (cs[r] == c) {
          ret = Math.max(ret, r - l);
        } else {
          while (cntNotTarget == k) {
            l++;
            if (cs[l] != c) {
              cntNotTarget--;
            }
          }
          cntNotTarget++;
          ret = Math.max(ret, r - l);
        }
        r++;
      }
    }
    return ret;
  }
}
