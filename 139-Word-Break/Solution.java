class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        boolean[] dp = new boolean[s.length() + 1];
        int max = 0;
        int min = s.length();
        for (String str : wordDict) {
            set.add(str);
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
        }
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = min; j <= max && j <= i; j++) {
                String word = s.substring(i - j, i);
                if (set.contains(word)) {
                    dp[i] |= dp[i - j];
                }
            }
        }

        return dp[s.length()];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);

        return helper(s, wordDict, 0, memo);
    }

    private boolean helper(String s, List<String> wordDict,
                          int index, int[] memo) {
        if (index == s.length()) return true;

        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word, index)) {
                int start = index + word.length();
                if (memo[start] == -1) {
                    memo[start] = helper(s, wordDict, start, memo) ? 1 : 0;
                }
                if (memo[start] == 1) return true;
            }
        }

        return false;
    }
}
