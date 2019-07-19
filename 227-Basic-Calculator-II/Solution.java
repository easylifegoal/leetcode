class Solution {
    public int calculate(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> digits = new Stack<>();

        char[] chs = s.toCharArray();
        int ans = 0;
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        int isFinished = 0;
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (ch == ' ') continue;
            if (ch >= '0' && ch <='9') {
                int digit = ch - '0';
                if (isFinished != 0) {
                    digit = digits.pop() * 10 + digit;
                }
                isFinished = 1;
                digits.push(digit);
            }
            if ("+-*/".indexOf(ch) != -1) {
                while (!operators.isEmpty()
                       && priority.get(ch) <= priority.get(operators.peek())) {
                    char op = operators.pop();
                    int two = digits.pop();
                    int one = digits.pop();
                    if (op == '+') digits.push(one + two);
                    if (op == '-') digits.push(one - two);
                    if (op == '*') digits.push(one * two);
                    if (op == '/') digits.push(one / two);
                }
                operators.push(ch);
                isFinished = 0;
            }
        }

        while (!operators.isEmpty()) {
            char op = operators.pop();
            int two = digits.pop();
            int one = digits.pop();
            if (op == '+') digits.push(one + two);
            if (op == '-') digits.push(one - two);
            if (op == '*') digits.push(one * two);
            if (op == '/') digits.push(one / two);
        }

        return digits.pop();
    }
}

class Solution {
    public int calculate(String s) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = new char[ch1.length];
        int[] stack = new int[ch1.length];
        //delete empty spaces
        int length = 0;
        for (char c : ch1) {
            if (c != ' ')
                ch2[length++] = c;
        }

        int cur = 0;
        int num = 0;
        int stackIdx = 0;
        char preOp = '+';
        while (cur < length) {
            num = 0;
            //get pre operator
            if (ch2[cur] == '+' || ch2[cur] == '-'
                    || ch2[cur] == '*' || ch2[cur] == '/')
                preOp = ch2[cur++];
            //get number
            while (cur < length && ch2[cur] >= '0' && ch2[cur] <= '9') {
                num = num * 10 + ch2[cur++] - '0';
            }
            switch (preOp) {
                case '+':
                    stack[stackIdx++] = num;
                    break;
                case '-':
                    stack[stackIdx++] = -num;
                    break;
                case '/':
                    stack[stackIdx - 1] = stack[stackIdx - 1] / num;
                    break;
                case '*':
                    stack[stackIdx - 1] = stack[stackIdx - 1] * num;
                    break;
            }

        }

        int ans = 0;
        for (int i = 0; i < stackIdx; i++) {
            ans += stack[i];
        }

        return ans;
    }
}
