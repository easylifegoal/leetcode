class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            int top = stack.peek();
            while (!stack.empty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int left = stack.empty() ? -1 : stack.peek();
                max = Math.max(max, (i - left - 1) * height);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int height = heights[stack.pop()];
            int left = stack.empty() ? -1 : stack.peek();
            max = Math.max(max, (heights.length - left - 1) * height);
        }

        return max;
    }
}
