import java.util.Arrays;

class Solution {
  public String multiply(String num1, String num2) {
    char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
    int digit1 = 0, digit2 = 0;
    int l1 = n1.length, l2 = n2.length;
    int l = l1 + l2;
    int[] memo = new int[l1 + l2];
    for (int i = l1 - 1; 0 <= i; i--) {
      digit2 = 0;
      for (int j = l2 - 1; 0 <= j; j--) {
        memo[l - digit2 - digit1 - 1] += (n1[i] - '0') * (n2[j] - '0');
        digit2++;
      }
      digit1++;
    }
    for (int i = l1 + l2 - 1; 0 < i; i--) {
      if (memo[i] >= 10) {
        memo[i - 1] += memo[i] / 10;
        memo[i] = memo[i] % 10;
      }
    }
    int i = 0;
    while (i < l1 + l2 - 1 && memo[i] == 0) {
      i++;
    }
    StringBuilder ret = new StringBuilder();
    for (int j = i; j < l1 + l2; j++) {
      ret.append(memo[j]);
    }

    return ret.toString();
  }

}
