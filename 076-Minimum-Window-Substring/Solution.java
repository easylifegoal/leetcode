class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        Map<Character, Integer> dicT = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = dicT.getOrDefault(c, 0) + 1;
            dicT.put(c, count);
        }

        int require = dicT.size();
        int produce = 0;
        int l = 0;
        int r = 0;
        //window's length, left index, right index
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> winCounts = new HashMap<>();

        while (r < s.length()) {
            char key = s.charAt(r);
            if (dicT.containsKey(key)) {
                int count = winCounts.getOrDefault(key, 0) + 1;
                winCounts.put(key, count);
                if (dicT.get(key).equals(winCounts.get(key)))
                    produce++;
                while (require == produce) {
                    if (ans[0] == -1 || ans[0] > r - l + 1) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }
                    char keyL = s.charAt(l);
                    if (dicT.containsKey(keyL)) {
                        int reduce = winCounts.get(keyL) - 1;
                        winCounts.put(keyL, reduce);
                        if (reduce < dicT.get(keyL).intValue())
                            produce--;
                    }
                    l++;
                }
            }
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        int[] chT = new int[128];
        for (char ch : t.toCharArray()) {
            chT[ch]++;
        }
        int count = t.length();
        int l = 0;
        int r = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        char[] chS = s.toCharArray();
        while (r < chS.length) {
            if (chT[chS[r++]]-- > 0) count--;

            while (count == 0) {
                if (r - l < length) {
                    start = l;
                    length = r - l;
                }
                if (chT[chS[l++]]++ == 0) count++;
            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
