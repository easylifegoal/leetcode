class Solution {
    public boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] memo = new boolean[text.length + 1][pattern.length + 1];
        memo[0][0] = true;
        for (int i = 1; i < memo[0].length; i++) {
            if (pattern[i - 1] == '*')
                memo[0][i] = memo[0][i - 2];
        }

        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    memo[i][j] = memo[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]){
                        memo[i][j] = memo[i][j] || memo[i - 1][j];
                    }
                } else {
                    memo[i][j] = false;
                }
            }
        }

        return memo[s.length()][p.length()];
    }
}
