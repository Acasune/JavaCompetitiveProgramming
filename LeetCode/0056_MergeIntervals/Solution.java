import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ret = new LinkedList<>();
        Set<Integer> points = new HashSet<>();
        int[] grandInterval = new int[10010];
        for (int i = 0; i < 10001; i++) {
            grandInterval[i] = 0;
        }
        for (var interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            grandInterval[start]++;
            grandInterval[end]--;
            if (start == end) {
                points.add(start);
            }
        }
        for (int i = 1; i < 10001; i++) {
            grandInterval[i] += grandInterval[i - 1];
        }
        int start = 0, end = 10001;
        for (int i = 1; i < 10001; i++) {
            if (grandInterval[i - 1] == 0 && grandInterval[i] != 0) {
                start = i;
            }
            if (grandInterval[i - 1] != 0 && grandInterval[i] == 0) {
                ret.add(new int[] { start, i });
            }
        }
        for (int p : points) {
            System.out.println(p);
            if ((p == 0 && grandInterval[p] == 0)) {
                ret.add(new int[] { p, p });
            } else if (p != 0 && grandInterval[p - 1] == 0 && grandInterval[p] == 0) {
                ret.add(new int[] { p, p });
            }
        }
        int[][] retArray = new int[ret.size()][2];
        for (int i = 0; i < ret.size(); i++) {
            retArray[i] = ret.get(i);
        }

        return retArray;
    }
}
