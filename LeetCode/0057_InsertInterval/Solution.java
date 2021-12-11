import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmps = new LinkedList<>();
        List<int[]> ret = new LinkedList<>();
        for (var e : intervals) {
            tmps.add(e);
        }
        tmps.add(newInterval);
        tmps.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        int left = -1, right = -1;
        for (var e : tmps) {
            if (left == -1 && right == -1) {
                left = e[0];
                right = e[1];
            } else if (e[0] > right) {
                ret.add(new int[] { left, right });
                left = e[0];
                right = e[1];
            } else {
                right = Math.max(right, e[1]);
            }
        }
        ret.add(new int[] { left, right });

        return ret.stream().toArray(int[][]::new);
    }
}
