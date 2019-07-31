/**
 * 1 3 -1 | -3 5 3 | 6 7
 * divide by k
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) max = Integer.MIN_VALUE;
            max = Math.max(max, nums[i]);
            left[i] = max;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if ((i + 1) % k == 0) max = Integer.MIN_VALUE;
            max = Math.max(max, nums[i]);
            right[i] = max;
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }

        return res;

    }
}
