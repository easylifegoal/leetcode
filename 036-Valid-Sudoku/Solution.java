class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] box = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1']) return false;
                    row[board[i][j] - '1'] = true;
                }
                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1']) return false;
                    col[board[j][i] - '1'] = true;
                }
                int m = i / 3 * 3 + j / 3;
                int n = i % 3 * 3 + j % 3;
                if (board[m][n] != '.') {
                    if (box[board[m][n] - '1']) return false;
                    box[board[m][n] - '1'] = true;
                }
            }
        }

        return true;
    }
}
