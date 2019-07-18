class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        char[] input = digits.toCharArray();
        if (input.length == 0) return ans;
        char[][] letters = new char[8][];
        letters[0] = "abc".toCharArray();
        letters[1] = "def".toCharArray();
        letters[2] = "ghi".toCharArray();
        letters[3] = "jkl".toCharArray();
        letters[4] = "mno".toCharArray();
        letters[5] = "pqrs".toCharArray();
        letters[6] = "tuv".toCharArray();
        letters[7] = "wxyz".toCharArray();

        ans.add("");
        for (char c : input) {
            List<String> tmp = new ArrayList<>();
            for (String str : ans) {
                for (char letter : letters[c - '2']) {
                    tmp.add(str + letter);
                }
            }
            ans = tmp;
        }

        return ans;
    }
}
