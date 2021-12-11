class Solution {
  public String decodeString(String s) {
    return getRepeatedString(0, s.toCharArray()).s;

  }

  private Bean getRepeatedString(int i, char[] chars) {
    String ret = "";
    while (i < chars.length) {
      if (chars[i] == '[') {
      } else if (chars[i] == ']') {
        break;
      } else if ('0' <= chars[i] && chars[i] <= '9') {
        String num = "";
        while ('0' <= chars[i] && chars[i] <= '9') {
          num = num + chars[i];
          i++;
        }
        int repeat = Integer.parseInt(num);
        Bean bean = getRepeatedString(i, chars);
        String s = "";
        for (int t = 0; t < repeat; t++) {
          s += bean.s;
        }
        ret += s;
        i = bean.i;
      } else {
        ret += chars[i];
      }
      i++;
    }
    return new Bean(i, ret);

  }

  static class Bean {
    int i;
    String s;

    Bean(int i, String s) {
      this.i = i;
      this.s = s;
    }
  }
}
