class Solution {
    public int numDecodings(String s) {
        int first = 0;
        int last = 0;
        if (s.charAt(0) != '0') {
            first = 1;
            last = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            int one = Integer.parseInt(s.substring(i, i + 1));
            int two = Integer.parseInt(s.substring(i - 1, i + 1));
            if (two == 0 || two > 26) {
                first = 0;
            }
            if (one == 0) {
                last = 0;
            }
            if (last == 0 && first == 0) {
                return 0;
            }
            int tmp = first;
            first = last;
            last = tmp + first;
        }

        return last;
    }
}
