class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        int temp = 0;
        //up to down
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                temp = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //reverse
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
