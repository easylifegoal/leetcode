class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] tmp = new char[n << 1];
        add(ans, tmp, 0, n, n);
        return ans;
    }

    public void add(List<String> ans, char[] tmp, int index, int l, int r) {
        if (l == 0 && r == 0) {
            ans.add(new String(tmp));
            return;
        }

        if (l > 0) {
            tmp[index] = '(';
            add(ans, tmp, index + 1, l - 1, r);
        }

        if (r > l) {
            tmp[index] = ')';
            add(ans, tmp, index + 1, l, r - 1);
        }
    }
}
