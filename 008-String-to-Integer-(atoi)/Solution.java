class Solution {
    public int myAtoi(String str) {
        char[] ch = str.toCharArray();
        int i = 0;
        int result = 0;
        int sign = 1;
        //delete white space
        while (i < ch.length && ch[i] == ' ') {
            i++;
        }

        if (i < ch.length && (ch[i] == '+' || ch[i] == '-')) {
            if (ch[i] == '-')
                sign = -1;
            i++;
        }

        while (i < ch.length) {
            int digit = ch[i] - '0';
            if (digit > 9 || digit < 0) break;

            if (Integer.MAX_VALUE / 10 < result
                    || (Integer.MAX_VALUE / 10 == result
                    && Integer.MAX_VALUE % 10 < digit))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}class Solution {
    public int myAtoi(String str) {
        char[] ch = str.toCharArray();
        int i = 0;
        int result = 0;
        int sign = 1;
        //delete white space
        while (i < ch.length && ch[i] == ' ') {
            i++;
        }

        if (i < ch.length && (ch[i] == '+' || ch[i] == '-')) {
            if (ch[i] == '-')
                sign = -1;
            i++;
        }

        while (i < ch.length) {
            int digit = ch[i] - '0';
            if (digit > 9 || digit < 0) break;

            if (Integer.MAX_VALUE / 10 < result
                    || (Integer.MAX_VALUE / 10 == result
                    && Integer.MAX_VALUE % 10 < digit))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
