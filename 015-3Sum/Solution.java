class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;

        Arrays.sort(nums);

        get2Sum(ans, nums, 1, nums.length - 1, nums[0]);

        for (int i =  1; i < nums.length - 2; i++) {
            if (nums[i] != nums[i - 1])
                get2Sum(ans, nums, i + 1, nums.length - 1, nums[i]);
        }

        return ans;
    }

    void get2Sum(List<List<Integer>> list, int[] nums,
                 int start, int end, int num) {
        int target = 0 - num;
        int lastStart = -1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else if (lastStart != -1 && nums[start] == nums[lastStart]) {
                start++;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[start]);
                temp.add(nums[end]);
                temp.add(num);
                list.add(temp);
                lastStart = start;
                start++;
                end--;
           }
        }
    }
}
