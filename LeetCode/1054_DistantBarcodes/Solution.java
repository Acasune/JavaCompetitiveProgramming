import java.util.Map;

class Solution {
  public int[] rearrangeBarcodes(int[] barcodes) {
    Map<Integer, Integer> mp = new HashMap<>();
    for (var i : barcodes) {
      mp.put(i, mp.getOrDefault(i, 0) + 1);
    }
    Integer[] sortedElem = Arrays.stream(barcodes).boxed().distinct().sorted((a, b) -> -mp.get(a) + mp.get(b))
        .toArray(Integer[]::new);
    int[] ans = new int[barcodes.length];
    int i = 0;
    for (var e : sortedElem) {
      while (mp.containsKey(e)) {
        ans[i] = e;
        if (i + 2 >= barcodes.length)
          i = 1;
        else
          i += 2;
        if (mp.get(e) == 1) {
          mp.remove(e);
        } else {
          mp.put(e, mp.get(e) - 1);
        }
      }
    }
    return ans;
  }
}
