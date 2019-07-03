class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;

        int left = 0;
        int right = nums.length - 1;
        int ptr = left;
        int temp = 0;

        while (ptr <= right) {
            if (nums[ptr] == 0) {
                temp = nums[ptr];
                nums[ptr] = nums[left];
                nums[left] = temp;
                left++;
                ptr = left;
            } else if (nums[ptr] == 2) {
                temp = nums[ptr];
                nums[ptr] = nums[right];
                nums[right] = temp;
                right--;
                ptr = left;
            } else {
                ptr++;
            }
        }
    }
}
