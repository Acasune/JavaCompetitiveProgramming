import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> st = new HashSet<>();
        int a;
        while (!st.contains(n)) {
            st.add(n);
            a = 0;
            while (n > 0) {
                a += (n % 10) * (n % 10);
                n /= 10;
            }
            n = a;
            if (n == 1) {
                return true;
            }
        }
        return false;

    }
}
