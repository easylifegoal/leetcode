class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0;
        int end = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > end - start) {
                start = i - ((max - 1) >> 1);
                end = start + max;
            }
        }

        return s.substring(start, end);
    }

    private int expand(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}

//some improvement to skip duplicate letters
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        //means length and start index
        int[] ans = {0, 0};
        int i = 0;
        while (i < s.length()) {
            i = expand(s, i, ans);
        }
        return s.substring(ans[1], ans[0] + ans[1]);
    }

    private int expand(String s, int i, int[] ans) {
        int l = i - 1;
        int r = i;
        while (r + 1 < s.length() && s.charAt(r + 1) == s.charAt(r)) {
            r++;
        }
        int newTail = r + 1;
        r++;
        //skip duplicate letters
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (r - l - 1 > ans[0]) {
            ans[0] = r - l - 1;
            ans[1] = l + 1;
        }

        return newTail;
    }
}
