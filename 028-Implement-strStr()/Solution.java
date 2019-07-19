class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null
                || haystack.length() < needle.length()) return -1;
        if (needle.length() == 0) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length())))
                return i;
        }

        return -1;
    }
}
