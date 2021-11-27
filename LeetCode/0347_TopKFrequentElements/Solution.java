class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    Arrays.sort(nums);
    int val = nums[0];
    int l = 0, r = 0;
    for (; l < nums.length; l++) {
      if (val != nums[l]) {
        map.put(val, l - r);
        r = l;
        val = nums[l];
      }
    }
    map.put(val, l - r);
    List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
    Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

    int[] ans = new int[k];
    int cnt = 0;
    for (var elem : entries) {
      if (cnt >= k)
        break;
      ans[cnt] = elem.getKey();
      cnt++;
    }

    return ans;

  }
}
