import java.util.Arrays;

class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> {
      if (a[1] != b[1]) {
        return a[1] - b[1];
      }
      return b[0] - a[0];
    });
    int[] now = intervals[0];
    int ret = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < now[1]) {
        ret++;
      }
      if (now[1] <= intervals[i][0]) {
        now = intervals[i];
      }

    }
    return ret;

  }
}
