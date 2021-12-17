class Solution {
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    String s = "1";
    int left = 0, right = 0;
    for (int i = 1; i < n; i++) {
      String tmp = "";
      left = 0;
      right = 0;
      while (right < s.length()) {
        if (s.charAt(left) != s.charAt(right)) {
          tmp += Integer.toString(right - left) + s.charAt(left);
          left = right;
        }
        right++;
      }
      s = tmp + Integer.toString(right - left) + s.charAt(left);
    }
    return s;
  }
}
