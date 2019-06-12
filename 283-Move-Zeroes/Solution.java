class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;

        //move arrays
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) continue;
            nums[index] = nums[i];
            index++;
        }

        for (int i = index; i < length; i++) {
            nums[i] = 0;
        }
    }
}
