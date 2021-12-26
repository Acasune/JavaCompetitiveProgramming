class Solution {
  public String shortestCommonSupersequence(String str1, String str2) {
    int n1 = str1.length();
    int n2 = str2.length();
    String[][] memo = new String[n1 + 1][n2 + 1];
    for (int i = 0; i < n1 + 1; i++) {
      for (int j = 0; j < n2 + 1; j++) {
        memo[i][j] = "";
      }
    }

    for (int i = 1; i < n1 + 1; i++) {
      for (int j = 1; j < n2 + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          if (memo[i - 1][j - 1].length() + 1 <= memo[i - 1][j].length()) {
            memo[i][j] = memo[i - 1][j];
          } else {
            memo[i][j] = memo[i - 1][j - 1] + str1.charAt(i - 1);
          }
          if (memo[i][j].length() <= memo[i][j - 1].length()) {
            memo[i][j] = memo[i][j - 1];
          }
        } else {
          if (memo[i - 1][j].length() <= memo[i][j - 1].length()) {
            memo[i][j] = memo[i][j - 1];
          } else {
            memo[i][j] = memo[i - 1][j];
          }
        }
      }
    }
    char[] common = memo[n1][n2].toCharArray();
    int i1 = 0;
    int i2 = 0;
    StringBuilder ret = new StringBuilder();
    for (int i = 0; i < common.length; i++) {
      while (true) {
        if (str1.charAt(i1) == common[i]) {
          i1++;
          break;
        }
        ret.append(str1.charAt(i1));
        i1++;
      }
      while (true) {
        if (str2.charAt(i2) == common[i]) {
          i2++;
          break;
        }
        ret.append(str2.charAt(i2));
        i2++;
      }
      ret.append(common[i]);
    }
    while (i1 < str1.length()) {
      ret.append(str1.charAt(i1));
      i1++;
    }
    while (i2 < str2.length()) {
      ret.append(str2.charAt(i2));
      i2++;
    }
    return ret.toString();

  }
}
