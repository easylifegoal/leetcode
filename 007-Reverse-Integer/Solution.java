class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        int flag = 0;
        if (x < 0) {
            flag = 1;
            x = -x;
        }
        int res = 0;
        while (x % 10 == 0) {
            x /= 10;
        }
        while (x > 0) {
            int tmp = x % 10;
            x /= 10;
            if (Integer.MAX_VALUE / 10 < res) return 0;
            res = res * 10 + tmp;
        }


        return flag == 0 ? res : -res;

    }
}
