class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        long ldiviend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long lans = compute(ldiviend, ldivisor);
        System.out.println(ldiviend);
        int ans = 0;
        if (lans > Integer.MAX_VALUE) {
            ans = isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            ans = (int) (isNeg ? -lans : lans);
        }
        return ans;

    }

    long compute(long ldiviend, long ldivisor) {
        if (ldiviend < ldivisor) {
            return 0;
        }
        long sum = 1;
        long cum = ldivisor;
        while (cum + cum <= ldiviend) {
            sum += sum;
            cum += cum;
        }
        return sum + compute(ldiviend - cum, ldivisor);

    }
}
