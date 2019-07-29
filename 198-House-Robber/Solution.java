class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int one = 0;
        int two = 0;
        for (int num : nums) {
            int tmp = two;
            two = Math.max(two, one + num);
            one = tmp;
        }

        return two;
    }
}
