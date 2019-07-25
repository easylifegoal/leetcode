class Solution {
    public int getSum(int a, int b) {
        int carry = a & b;
        int ans = a ^ b;
        while (carry != 0) {
            carry = carry << 1;
            int tmp = carry;
            carry = carry & ans;
            ans = ans ^ tmp;
        }

        return ans;
    }
}
