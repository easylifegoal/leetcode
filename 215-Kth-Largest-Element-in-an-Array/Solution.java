class Solution {
    public int findKthLargest(int[] nums, int k) {

        return partition(nums, 0, nums.length - 1, k - 1);
    }

    private int partition(int[] nums, int l, int r, int k) {
        int index = l;
        int swap = l;
        int mid = (l + r) >> 1;
        int pivot = nums[mid];
        nums[mid] = nums[r];
        while (index < r) {
            if (nums[index] > pivot) {
                int tmp = nums[swap];
                nums[swap] = nums[index];
                nums[index] = tmp;
                swap++;
            }
            index++;
        }

        if (swap == k) return pivot;
        nums[r] = nums[swap];
        nums[swap] = pivot;

        if (swap > k) return partition(nums, l, swap - 1, k);

        return partition(nums, swap + 1, r, k);
    }

}
