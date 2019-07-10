class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, words, 0))
                    return true;
            }
        }

        return false;
    }

    boolean search(char[][] board, int i, int j,
            char[] words, int index) {
        if (index == words.length)
            return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length
                || board[i][j] != words[index])
            return false;

        board[i][j] ^= 256;
        boolean exist = search(board, i + 1, j, words, index + 1)
            || search(board, i - 1, j, words, index + 1)
            || search(board, i, j + 1, words, index + 1)
            || search(board, i, j - 1, words, index + 1);
        board[i][j] ^= 256;

        return exist;
    }
}
