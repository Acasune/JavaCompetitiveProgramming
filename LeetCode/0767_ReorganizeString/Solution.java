class Solution {
  public String reorganizeString(String s) {
    char[] chars = s.toCharArray();
    int[] freqs = new int[26];
    for (char c : chars) {
      freqs[c - 'a']++;
    }
    int maxIdx = 0;
    for (int i = 0; i < 26; i++) {
      if (freqs[maxIdx] < freqs[i]) {
        maxIdx = i;
      }
    }
    if (freqs[maxIdx] > (s.length() + 1) / 2)
      return "";
    int idx = 0;
    char[] ret = new char[s.length()];
    while (freqs[maxIdx] > 0) {
      ret[idx] = (char) (maxIdx + 'a');
      freqs[maxIdx]--;
      idx += 2;
      if (idx >= s.length()) {
        idx = 1;
      }
    }

    for (int i = 0; i < 26; i++) {
      while (freqs[i] > 0) {
        ret[idx] = (char) (i + 'a');
        freqs[i]--;
        idx += 2;
        if (idx >= s.length()) {
          idx = 1;
        }
      }
    }

    return String.valueOf(ret);
  }
}
