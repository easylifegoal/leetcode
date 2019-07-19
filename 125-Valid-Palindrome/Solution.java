class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        char[] ch1 = s.toCharArray();
        char[] ch2 = new char[ch1.length];
        int length = 0;
        //ignor
        for (char c : ch1) {
            if (c >= 'A' && c <= 'Z'
                    || c >= '0' && c <= '9')
                ch2[length++] = c;
            if (c >= 'a' && c <= 'z')
                ch2[length++] = (char)(c + 'A' -'a');
        }

        for (int i = 0; i <= (length >> 1) - 1; i++)
            if (ch2[i] != ch2[length - i -1])
                return false;

        return true;
    }
}
