class Solution {
    public void reverseString(char[] s) {
        int mid = s.length >> 1;
        for (int i = 0; i < mid; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }
}
