class Solution {
    public int[] plusOne(int[] digits) {
        int temp = 0;
        int length = digits.length;
        digits[length - 1] = digits[length - 1] + 1;
        if (digits[length - 1] < 10) return digits;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + temp;
            if (digits[i] > 9) {
                temp = digits[i] / 10;
                digits[i] = digits[i] % 10;
            } else {
                return digits;
            }
        }

        if (temp > 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = temp;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }

            digits = ans;
        }

        return digits;
    }
}

class Solution {
public int[] plusOne(int[] digits) {
    int carry = 1;
    for (int i = digits.length-1; i>= 0; i--) {
        digits[i] += carry;
        if (digits[i] <= 9) // early return
            return digits;
        digits[i] = 0;
    }
    int[] ret = new int[digits.length+1];
    ret[0] = 1;
    return ret;
}
}
