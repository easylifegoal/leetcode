class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                flag++;
            } else if (flag == 0) {
                majority = nums[i];
            } else {
                flag--;
            }
        }

        return majority;
    }
}
