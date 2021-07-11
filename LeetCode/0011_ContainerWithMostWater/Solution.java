class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = right * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] <= height[right]) {
                // l is shorter than r
                left++;
            } else {
                right--;
            }
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
        }
        return res;
    }
}
