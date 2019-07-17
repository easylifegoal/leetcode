class Solution {
    public void wiggleSort(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int index = tmp.length - 1;
        for (int i = 1; i < nums.length; i += 2)
            nums[i] = tmp[index--];
        for (int i = 0; i < nums.length; i += 2)
            nums[i] = tmp[index--];
    }
}
