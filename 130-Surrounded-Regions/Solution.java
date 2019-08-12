class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;

        for (int i = 0; i < m; i++) {
            helper(board, i, 0);
            helper(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            helper(board, 0, i);
            helper(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void helper(char[][] board, int x, int y) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
            return;
        }
        if (board[x][y] != 'O') return;

        board[x][y] = 'A';
        helper(board, x + 1, y);
        helper(board, x - 1, y);
        helper(board, x, y + 1);
        helper(board, x, y - 1);
    }
}
