class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int right, left, up, down, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                right = j + 1;
                left = j - 1;
                up = i - 1;
                down = i + 1;

                if (left >= 0) {
                    if (board[i][left] >= 1) count++;
                    if (up >= 0 && board[up][left] >= 1) count++;
                    if (down < m && board[down][left] >= 1) count++;
                }

                if (right < n) {
                    if (board[i][right] >= 1) count++;
                    if (up >= 0 && board[up][right] >= 1) count++;
                    if (down < m && board[down][right] >= 1) count++;
                }

                if (up >= 0 && board[up][j] >= 1) count++;
                if (down < m && board[down][j] >= 1) count++;

                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) board[i][j] = 2;
                }

                if (board[i][j] == 0 && count == 3) board[i][j] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] < 0) board[i][j] = 1;
                if (board[i][j] > 1) board[i][j] = 0;
            }
        }
    }
}
