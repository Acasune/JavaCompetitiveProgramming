class Solution {
  public int search(int[] nums, int target) {

    int l = 0;
    int r = nums.length - 1;
    int m = -1;

    while (r - 1 > l) {
      m = (r + l) / 2;
      if (nums[r] > nums[m]) {
        r = m;
      } else {
        l = m;
      }

    }
    if (!(nums[l] >= nums[r])) {
      // nums are already sorted
      Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
      int idx = ~Arrays.binarySearch(arr, target, (x, y) -> x.compareTo(y) >= 0 ? 1 : -1);

      if (nums.length <= idx) {
        return -1;
      }
      if (nums[idx] == target) {
        return idx;
      } else {
        return -1;
      }
    } else {
      // nums have boundary in arr
      int ret = -1;
      Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
      if (nums[0] <= target && target <= nums[l]) {
        int idx = ~Arrays.binarySearch(Arrays.copyOfRange(arr, 0, l + 1), target,
            (x, y) -> x.compareTo(y) >= 0 ? 1 : -1);
        if (nums[idx] == target) {
          return idx;
        }
      } else if (nums[r] <= target && target <= nums[nums.length - 1]) {
        int idx = ~Arrays.binarySearch(Arrays.copyOfRange(arr, l + 1, nums.length - 1), target,
            (x, y) -> x.compareTo(y) >= 0 ? 1 : -1);
        idx = l + 1 + idx;
        if (nums.length <= idx) {
          return -1;
        }
        if (nums[idx] == target) {
          return idx;
        }
      }

    }
    return -1;

  }
}
