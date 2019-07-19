class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] map = new int[128];
        char[] ch = s.toCharArray();
        int r = 0;
        int l = 0;
        int length = 0;
        int count = 0;
        while (r < ch.length) {
            if (map[ch[r++]]++ != 0) {
                length = Math.max(r - l - 1, length);
                while (map[ch[l++]]-- == 1) {}
            }
        }

        return Math.max(length, r - l);
    }
}
