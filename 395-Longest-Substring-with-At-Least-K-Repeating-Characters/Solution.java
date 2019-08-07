class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length() - 1, k);
    }

    private int helper(char[] chs, int left, int right, int k) {
        if (right - left + 1 < k) return 0;
        int[] counts = new int[26];
        for (int i = left; i <= right; i++) {
            counts[chs[i] - 'a']++;
        }
        for (int i = left; i <= right; i++) {
            if (counts[chs[i] - 'a'] < k) {
                int j = i + 1;
                while (j <= right && counts[chs[j] - 'a'] < k) j++;
                return Math.max(helper(chs, left, i - 1, k),
                               helper(chs, j, right, k));
            }
        }

        return right - left + 1;
    }
}
