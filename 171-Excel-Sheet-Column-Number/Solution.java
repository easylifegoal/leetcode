class Solution {
    public int titleToNumber(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        char[] chs = s.toCharArray();
        int carry = 1;
        for (int i = chs.length - 1; i >= 0; i--) {
            res += (chs[i] - 'A' + 1) * carry;
            carry *= 26;
        }

        return res;
    }
}
