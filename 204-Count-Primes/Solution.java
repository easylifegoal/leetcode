class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;

        int res = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = i + i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if(!notPrime[i]) res++;
        }

        return res;
    }
}
