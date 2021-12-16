class MagicDictionary {
  String[] words;

  public MagicDictionary() {

  }

  public void buildDict(String[] dictionary) {
    words = dictionary;
  }

  public boolean search(String searchWord) {
    for (var dictWord : words) {
      if (dictWord.length() != searchWord.length()) {
        continue;
      }
      int affinity = 0;
      int idx = 0;
      while (idx < searchWord.length()) {
        if (dictWord.charAt(idx) != searchWord.charAt(idx)) {
          affinity++;
          if (affinity >= 2) {
            break;
          }
        }
        idx++;
      }
      if (affinity == 1) {
        return true;
      }
    }
    return false;
  }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
