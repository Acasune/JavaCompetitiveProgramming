class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] memo = Integer.toString(x).toCharArray();
        int l = 0, r = memo.length - 1;
        while (l < r) {
            if (memo[l] != memo[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
