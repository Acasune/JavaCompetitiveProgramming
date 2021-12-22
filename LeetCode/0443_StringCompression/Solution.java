class Solution {
  public int compress(char[] chars) {
    int cnt = 1;
    char now = chars[0];
    int idx = 0;
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] != now) {
        chars[idx] = now;
        if (cnt > 1) {
          int digit = 0;
          int tmpCnt = cnt;
          while (tmpCnt > 0) {
            tmpCnt /= 10;
            digit++;
          }
          for (int j = digit; 0 < j; j--) {
            chars[idx + j] = String.valueOf(cnt % 10).charAt(0);
            cnt /= 10;
          }
          idx += digit;
        }
        now = chars[i];
        cnt = 1;
        idx++;
      } else {
        cnt++;
      }
    }
    chars[idx] = now;
    if (cnt > 1) {
      int digit = 0;
      int tmpCnt = cnt;
      while (tmpCnt > 0) {
        tmpCnt /= 10;
        digit++;
      }
      for (int j = digit; 0 < j; j--) {
        chars[idx + j] = String.valueOf(cnt % 10).charAt(0);
        cnt /= 10;
      }
      idx += digit;
    }
    return idx + 1;
  }
}
