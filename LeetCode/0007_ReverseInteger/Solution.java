class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        if (isNeg) {
            x = -x;
        }
        String s = String.valueOf(x);
        s = new StringBuilder(s).reverse().toString();
        if (isNeg && isLeftLargerOrEqual("2147483648", s)) {
            return -Integer.valueOf(s);
        }
        if (!isNeg && isLeftLargerOrEqual("2147483647", s)) {
            return Integer.valueOf(s);
        }
        return 0;
    }

    private boolean isLeftLargerOrEqual(String left, String right) {
        if (left.length() != right.length()) {
            return left.length() > right.length();
        }
        char[] leftChars = left.toCharArray();
        char[] rightChars = right.toCharArray();
        for (int i = 0; i < leftChars.length; i++) {
            if (leftChars[i] != rightChars[i]) {
                return leftChars[i] > rightChars[i];
            }
        }
        return true;
    }
}
