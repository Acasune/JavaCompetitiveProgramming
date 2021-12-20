class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long y = (long) x;
        long ret = 1;
        while (true) {
            if ((ret + 1) * (ret + 1) > y) {
                break;
            }
            ret++;
        }
        return (int) ret;
    }
}
