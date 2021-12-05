class Solution {
  public int[] sumZero(int n) {
    int[] ret = new int[n];
    int i = 0;
    if (n % 2 == 1) {
      i = 1;
    }
    int base = 1;
    for (; i < n; i += 2) {
      ret[i] = base;
      ret[i + 1] = -base;
      base++;
    }
    return ret;

  }
}
