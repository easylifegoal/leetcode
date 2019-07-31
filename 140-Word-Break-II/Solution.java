class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int[] memo = new int[s.length() + 1];
        helper(s, wordDict, memo, 0, sb, res);

        return res;
    }

    private boolean helper(String s, List<String> wordDict, int[] memo, int index,
                       StringBuilder sb, List<String> res) {
        if (s.length() == index) {
            res.add(sb.toString().trim());
            return true;
        }
        boolean isValid = false;
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word, index)) {
                int pos = index + word.length();
                if (memo[pos] == 1) continue;
                int start = sb.length();
                sb.append(word).append(" ");
                isValid |= helper(s, wordDict, memo, pos, sb, res);
                sb.setLength(start);
            }
        }

        if (!isValid) memo[index] = 1;

        return isValid;
    }
}
