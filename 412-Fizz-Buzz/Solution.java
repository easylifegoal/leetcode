class Solution {
    public List<String> fizzBuzz(int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1 + "";
        }
        for (int i = 2; i < n; i += 3) {
            res[i] = "Fizz";
        }
        for (int i = 4; i < n; i += 5) {
            res[i] = "Buzz";
        }
        for (int i = 14; i < n; i += 15) {
            res[i] = "FizzBuzz";
        }

        return Arrays.asList(res);
    }
}
