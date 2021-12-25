class Solution {
  public String reverseStr(String s, int k) {
    if (s.length() < k) {
      return new StringBuilder(s).reverse().toString();
    }
    int l = 0, r = k;
    int m = 0;
    StringBuilder sb = new StringBuilder();
    while (true) {
      while (m < l) {
        sb.append(s.charAt(m++));
      }
      if (l >= s.length()) {
        break;
      }
      m = r - 1;
      while (l <= m) {
        sb.append(s.charAt(m--));
      }
      m = r;
      l = Math.min(r + k, s.length());
      r = Math.min(r + k * 2, s.length());
    }
    return sb.toString();
  }
}
