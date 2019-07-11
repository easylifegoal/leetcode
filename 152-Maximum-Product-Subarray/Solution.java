class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = nums[0];
        int tmp = 1;
        //from left to right
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (max < 0)
                    max = 0;
                tmp = 1;
            } else {
                tmp *= nums[i];
                max = Math.max(max, tmp);
            }
        }

        //from right to left
        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                tmp = 1;
            } else {
                tmp *= nums[i];
                max = Math.max(max, tmp);
            }
        }

        return max;
    }
}
