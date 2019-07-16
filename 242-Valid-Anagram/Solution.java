class Solution {
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        if (c1.length != c2.length) return false;
        int[] arr = new int[256];

        for (char c : c1)
            arr[c]++;

        for (char c : c2)
            arr[c]--;

        for (int i : arr)
            if (i != 0)
                return false;

        return true;
    }
}
