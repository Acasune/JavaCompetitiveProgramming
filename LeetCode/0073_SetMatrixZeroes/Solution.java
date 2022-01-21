class Solution {
    public void setZeroes(int[][] matrix) {
        int leftUpper = matrix[0][0];
        int upperEdge = -1;
        int leftEdge = -1;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = 1; j < m; j++) {
            if (matrix[j][0] == 0) {
                leftEdge = 0;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                upperEdge = 0;
                break;
            }
        }
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (matrix[j][i] == 0) {
                    matrix[j][0] = 0;
                    matrix[0][i] = 0;
                }
            }
        }
        for (int j = 1; j < m; j++) {
            if (matrix[j][0] == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (upperEdge == 0 || leftUpper == 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (leftEdge == 0 || leftUpper == 0) {
            for (int j = 0; j < m; j++) {
                matrix[j][0] = 0;
            }
        }

    }
}
