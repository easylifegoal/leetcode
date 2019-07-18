class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty()) return false;
                char e = stack.pop();
                if (e != map.get(ch)) return false;
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
