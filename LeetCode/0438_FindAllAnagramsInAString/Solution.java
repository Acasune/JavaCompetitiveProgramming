class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ret = new LinkedList<>();
    int[] ps = new int[26];
    int pSize = p.length(), sSize = s.length();
    for (char a : p.toCharArray()) {
      ps[a - 'a']++;
    }
    int[][] ss = new int[26][sSize + 1];
    for (int i = 1; i < sSize + 1; i++) {
      int c = s.charAt(i - 1) - 'a';
      ss[c][i] = 1;
    }
    for (int i = 1; i < sSize + 1; i++) {
      for (int j = 0; j < 26; j++) {
        ss[j][i] += ss[j][i - 1];
      }
    }
    for (int i = 1; i + pSize <= sSize + 1; i++) {
      boolean flg = true;
      for (int j = 0; j < 26; j++) {
        if (ss[j][i + pSize - 1] - ss[j][i - 1] != ps[j]) {
          flg = false;
          break;
        }
      }
      if (flg) {
        ret.add(i - 1);
      }
    }
    return ret;

  }
}
