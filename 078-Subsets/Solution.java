class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        int total = (1 << length) - 1;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= total; i++) {
            int index = 0;
            int arr = i;
            List<Integer> item = new ArrayList<>();
            while(arr != 0) {
                if ((arr & 1) != 0) {
                    item.add(nums[index]);
                }
                arr = arr >> 1;
                index++;
            }
            result.add(item);
        }

        return result;
    }
}
