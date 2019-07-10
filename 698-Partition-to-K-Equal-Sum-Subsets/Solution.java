class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;

        int target = sum / k;
        Arrays.sort(nums);
        int row = nums.length - 1;
        while (row >= 0 && nums[row] >= target) {
            if (nums[row] > target)
                return false;
            row--;
            k--;
        }

        return search(new int[k], nums, row, target);
    }

    boolean search(int groups[], int[] nums, int row, int target) {
        if (row < 0) return true;

        int value = nums[row];
        row--;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + value <= target) {
                groups[i] += value;
                if (search(groups, nums, row, target))
                    return true;
                groups[i] -= value;
            }
            if (groups[i] == 0) break;
        }

        return false;
    }
}
