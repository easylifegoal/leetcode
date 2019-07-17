class Solution {
    public int romanToInt(String s) {
        String symbols = "IVXLCDM";
        int[] values = {1, 5, 10, 50, 100, 500, 1000};

        int ans = 0;
        char[] tmp = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tmp.length; i++) {
            int item = values[symbols.indexOf(tmp[i])];
            if (stack.isEmpty() || stack.peek() >= item) {
                stack.push(item);
            } else {
                while (!stack.isEmpty() && stack.peek() < item) {
                    ans -= stack.pop();
                }
                stack.push(item);
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}
