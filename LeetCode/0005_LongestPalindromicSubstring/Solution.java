import java.util.Arrays;

class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String ans = String.valueOf(chars[0]);

        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (isPalindromic(i, j, chars) && j - i > ans.length()) {
                    ans = String.valueOf(Arrays.copyOfRange(chars, i, j + 1));

                }
            }
        }

        return ans;
    }

    private boolean isPalindromic(int left, int right, char[] substring) {
        while (left <= right) {
            if (substring[left] != substring[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
