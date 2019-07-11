class Solution {
    public int firstMissingPositive(int[] nums) {
        int result = 1;
        //swap number to the right position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0) {
                swap(nums, i);
            }
        }

        //find wrong position number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != result) {
                return result;
            }
            result++;
        }

        return result;
    }

    void swap(int[] nums, int i) {
        int tmp = nums[i];
        if (nums[i] == nums[tmp -1])
            return;

        nums[i] = nums[tmp - 1];
        nums[tmp - 1] = tmp;
        if (nums[i] > 0 && nums[i] < nums.length)
            swap(nums, i);
    }
}
