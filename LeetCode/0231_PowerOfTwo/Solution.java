class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    if (n == 1) {
      return true;
    }
    int base = 1;
    for (int i = 0; i < 31; i++) {
      base *= 2;
      if (base == n) {
        return true;
      }
    }
    return false;
  }
}
