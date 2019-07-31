class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s.toCharArray(), 0);

        return res;
    }

    private void dfs(List<List<String>> res, List<String> list,
                     char[] ch, int index) {
        if (index == ch.length) res.add(new ArrayList(list));

        for (int i = index; i < ch.length; i++) {
            if (isPal(ch, index, i)) {
                list.add(new String(ch, index, i - index + 1));
                dfs(res, list, ch, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPal(char[] ch, int l, int r) {
        while(l < r) {
            if (ch[l++] != ch[r--]) return false;
        }

        return true;
    }
}
