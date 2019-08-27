class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i < ans.length; i++) {
            int count = 0;
            int n = i;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            ans[i] = count;
        }

        return ans;
    }
}
