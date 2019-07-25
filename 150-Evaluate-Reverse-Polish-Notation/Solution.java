class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            switch(str) {
                case "+" :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-" :
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*" :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/" :
                    int n = stack.pop();
                    stack.push(stack.pop() / n);
                    break;
                default :
                    stack.push(Integer.parseInt(str));
            }
        }

        return stack.isEmpty() ? 0 : stack.pop();
    }
}
