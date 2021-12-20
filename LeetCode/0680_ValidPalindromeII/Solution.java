class Solution {
  public boolean validPalindrome(String s) {
    int l = 0, r = s.length() - 1, n = s.length();
    boolean isPalidrome = true, hasDelete = false;
    char[] cArr = s.toCharArray();
    while (l <= r) {
      if (cArr[l] != cArr[r]) {
        if (hasDelete) {
          isPalidrome = false;
          break;
        }
        hasDelete = true;
        l++;
      } else {
        l++;
        r--;
      }
    }
    if (isPalidrome) {
      return true;
    }
    l = 0;
    r = n - 1;
    isPalidrome = true;
    hasDelete = false;
    while (l <= r) {
      if (cArr[l] != cArr[r]) {
        if (hasDelete) {
          isPalidrome = false;
          break;
        }
        hasDelete = true;
        r--;
      } else {
        l++;
        r--;
      }
    }
    return isPalidrome;
  }
}
