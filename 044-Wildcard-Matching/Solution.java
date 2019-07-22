// dp solution
class Solution {
    public boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] memo = new boolean[text.length + 1][pattern.length + 1];
        memo[0][0] = true;
        for (int i = 1; i < memo[0].length; i++) {
            if (pattern[i - 1] == '*') {
                memo[0][i] = memo[0][i - 1];
            }
        }

        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                if (pattern[j - 1] == '?' || pattern[j - 1] == text[i - 1]) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    memo[i][j] = memo[i - 1][j] || memo[i][j - 1];
                } else {
                    memo[i][j] = false;
                }
            }
        }

        return memo[text.length][pattern.length];
    }
}

// two pointer solution
class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0;
        int pIdx = 0;
        int star = -1;
        int matched = 0;
        while (sIdx < s.length()) {
            if (pIdx < p.length() && (p.charAt(pIdx) == '?'
                    || s.charAt(sIdx) == p.charAt(pIdx))) {
                sIdx++;
                pIdx++;
            } else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                pIdx++;
                star = pIdx;
                matched = sIdx;
            } else if (star != -1) {
                matched++;
                sIdx = matched;
                pIdx = star;
            } else {
                return false;
            }
        }

        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == p.length();

    }
}
