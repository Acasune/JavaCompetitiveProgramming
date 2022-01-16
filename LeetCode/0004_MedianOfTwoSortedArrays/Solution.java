class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int l = (n + m + 1) / 2, r = (n + m + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private double getKth(int[] A, int idxA, int[] B, int idxB, int k) {
        if (A.length <= idxA)
            return B[idxB + k - 1];
        if (B.length <= idxB)
            return A[idxA + k - 1];
        if (k == 1)
            return Math.min(A[idxA], B[idxB]);

        int aMid = Integer.MAX_VALUE;
        int bMid = Integer.MAX_VALUE;
        if (idxA + k / 2 - 1 < A.length)
            aMid = A[idxA + k / 2 - 1];
        if (idxB + k / 2 - 1 < B.length)
            bMid = B[idxB + k / 2 - 1];

        if (aMid < bMid) {
            return getKth(A, idxA + k / 2, B, idxB, k - k / 2);
        } else {
            return getKth(A, idxA, B, idxB + k / 2, k - k / 2);
        }

    }
}
