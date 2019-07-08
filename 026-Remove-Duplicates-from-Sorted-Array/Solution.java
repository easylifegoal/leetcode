class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int ptr = 1;

        while (ptr < nums.length) {
            if (nums[ptr] > nums[index]) {
                index++;
                nums[index] = nums[ptr];
            }
            ptr++;
        }

        return index + 1;
    }
}
