class Solution {
    public int uniquePaths(int m, int n) {
        int[] result = new int[n];

        for (int j = 0; j < n; j++) {
            result[j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[j] = result[j - 1] + result[j];
            }
        }

        return result[n - 1];
    }
}
