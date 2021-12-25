class Solution {
  public String addStrings(String num1, String num2) {
    char[] arr1 = num1.toCharArray();
    char[] arr2 = num2.toCharArray();
    int n1 = num1.length();
    int n2 = num2.length();
    int i1 = n1 - 1;
    int i2 = n2 - 1;
    String ret = "";
    int next = 0;
    while (0 <= i1 || 0 <= i2) {
      int tmp1 = 0;
      int tmp2 = 0;
      if (0 <= i1) {
        tmp1 = (int) arr1[i1] - '0';
      }
      if (0 <= i2) {
        tmp2 = (int) arr2[i2] - '0';
      }
      ret = (tmp1 + tmp2 + next) % 10 + ret;
      i1--;
      i2--;
      next = (tmp1 + tmp2 + next) / 10;
    }
    if (next != 0) {
      ret = next + ret;
    }
    return ret;
  }
}
