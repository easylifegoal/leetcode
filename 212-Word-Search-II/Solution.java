class Solution {
    class Trie {
        Trie[] child;
        String word;
        public Trie() {
            child = new Trie[26];
        }
    }

    Trie root = new Trie();

    private void buildTrie(String word) {
        Trie tmp = root;
        for (char ch : word.toCharArray()) {
            if (tmp.child[ch - 'a'] == null) {
                tmp.child[ch - 'a'] = new Trie();
            }
            tmp = tmp.child[ch - 'a'];
        }
        tmp.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            buildTrie(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0;j < board[0].length; j++) {
                search(res, root, board, i, j);
            }
        }

        return res;
    }

    private void search(List<String> res, Trie root, char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] < 'a' || board[i][j] > 'z'
                || root.child[board[i][j] - 'a'] == null)
            return;

        root = root.child[board[i][j] - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }


        board[i][j] ^= 256;
        search(res, root, board, i + 1, j);
        search(res, root, board, i - 1, j);
        search(res, root, board, i, j + 1);
        search(res, root, board, i, j - 1);
        board[i][j] ^= 256;
    }
}
