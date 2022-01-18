
import java.util.Arrays;

class Solution {
  public int longestSubstring(String s, int k) {
    char[] cs = s.toCharArray();
    int[] memo = new int[26];
    int i = 0, j = 0, unique = 0, nMoreThanK = 0, n = s.length();
    int ret = 0;
    for (int h = 1; h <= 26; h++) {
      Arrays.fill(memo, 0);
      i = 0;
      j = 0;
      unique = 0;
      nMoreThanK = 0;
      while (j < n) {
        if (unique <= h) {
          int ci = cs[j] - 'a';
          if (memo[ci] == 0) {
            unique++;
          }
          memo[ci]++;
          if (memo[ci] == k) {
            nMoreThanK++;
          }
          j++;
        } else {
          int ci = cs[i] - 'a';
          if (memo[ci] == k) {
            nMoreThanK--;
          }
          memo[ci]--;
          if (memo[ci] == 0) {
            unique--;
          }
          i++;
        }
        if (unique == h && unique == nMoreThanK) {
          ret = Math.max(ret, j - i);
        }
      }

    }
    return ret;

  }
}
