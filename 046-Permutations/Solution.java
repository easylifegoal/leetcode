class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, list);

        return list;
    }

    private void helper(int[] nums, int index, List<List<Integer>> list) {
        if (index == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums)
                tmp.add(num);
            list.add(tmp);
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            helper(nums, index + 1, list);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
