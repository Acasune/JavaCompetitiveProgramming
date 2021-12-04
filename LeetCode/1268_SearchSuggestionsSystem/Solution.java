class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> res = new ArrayList<>();
    int n = products.length;
    Arrays.sort(products);
    for (int i = 0; i < searchWord.length(); i++) {
      String word = searchWord.substring(0, i + 1);
      int idx = Arrays.binarySearch(products, word);
      if (idx < 0) {
        idx = -idx - 1;
      }
      List<String> list = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        int k = j + idx;
        if (k < n && products[k].startsWith(word)) {
          list.add(products[k]);
        }
      }
      res.add(list);
    }
    return res;
  }
}
