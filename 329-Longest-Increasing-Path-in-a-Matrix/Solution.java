class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, path(matrix, memo, i, j, Integer.MIN_VALUE));
            }
        }

        return max;
    }

    private int path(int[][] matrix, int[][] memo, int i, int j, int num) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
                || matrix[i][j] <= num)
            return 0;
        if (memo[i][j] != 0) return memo[i][j];

        int tmp = matrix[i][j];
        int max = Math.max(path(matrix, memo, i + 1, j, tmp) + 1,
                           path(matrix, memo, i - 1, j, tmp) + 1);
        max = Math.max(max, path(matrix, memo, i, j + 1, tmp) + 1);
        max = Math.max(max, path(matrix, memo, i, j - 1, tmp) + 1);

        memo[i][j] = max;
        return max;
    }
}
