class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int[] ans = {start, end};
        if (nums.length == 0 || target < nums[0]
                || target > nums[nums.length - 1])
            return ans;

        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (r - l) / 2 + l;

            if (nums[mid] == target) {
                start = mid;
                end = mid;
                while (start >= 0 && nums[start] == target)
                    start--;
                while (end < nums.length && nums[end] == target)
                    end++;
                ans[0] = start + 1;
                ans[1] = end - 1;
                return ans;
            }

            if (nums[mid] > target)
                r = mid - 1;
            if (nums[mid] < target)
                l = mid + 1;
        }

        return ans;
    }
}
