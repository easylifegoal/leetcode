class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (set.contains(n)) return false;
        set.add(n);

        int tmp = 0;
        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            tmp += num * num;
        }

        return isHappy(tmp);
    }
}
