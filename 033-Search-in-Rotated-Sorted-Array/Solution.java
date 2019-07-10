class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (r - l) / 2 + l;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] > nums[r]) {
            if (nums[mid] > target && nums[l] <= target)
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (nums[mid] < target && nums[r] >= target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        return -1;
    }
}
