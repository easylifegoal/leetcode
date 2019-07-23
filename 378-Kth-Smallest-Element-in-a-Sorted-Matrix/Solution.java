class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while (low <= high) {
            int mid = low + ((high  - low) >> 1);
            int count = search(matrix, mid);
            if (count < k) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    private int search(int[][] matrix, int val) {
        int length = matrix.length;
        int i = length - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < length) {
            if (matrix[i][j] > val) i--;
            else {
                count += i + 1;
                j++;
            }
        }

        return count;
    }
}
