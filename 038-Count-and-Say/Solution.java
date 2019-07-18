class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        while (n > 1) {
            char[] tmp = ans.toCharArray();
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while (idx < tmp.length) {
                int count = 0;
                int last = idx;
                while(last < tmp.length && tmp[last] == tmp[idx]) {
                    last++;
                    count++;
                }
                sb.append(count).append(tmp[idx]);
                idx = last;
            }
            ans = sb.toString();
            n--;
        }

        return ans;
    }
}
