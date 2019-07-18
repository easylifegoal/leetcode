class Solution {
    public int firstUniqChar(String s) {
        char[] tmp = s.toCharArray();
        int[] count = new int[26];
        for (char ch : tmp) {
            count[ch - 'a'] += 1;
        }

        for (int i = 0; i < tmp.length; i++) {
            if (count[tmp[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        int idx = Integer.MAX_VALUE;
        for (int i = 'a'; i <= 'z'; i++) {
            int first = s.indexOf(i);
            int last = s.lastIndexOf(i);
            if (first != -1 && first == last && first < idx) {
                idx = first;
            }
        }

        return idx == Integer.MAX_VALUE ? -1 : idx;
    }
}
