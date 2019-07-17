class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] index = new int[nums.length];
        int[] counts = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, counts, index, 0, nums.length - 1);
        List<Integer> list = new ArrayList<>();
        for (int i : counts) {
            list.add(i);
        }
        return list;
    }

    void mergeSort(int[] nums, int[] counts, int[] index, int low, int high) {
        if (low < high) {
            int mid = low + ((high - low) >> 1);

            mergeSort(nums, counts, index, low, mid);
            mergeSort(nums, counts, index, mid + 1, high);
            merge(nums, counts, index, low, mid, high);
        }
    }

    void merge(int[] nums, int[] counts, int[] index, int low, int mid, int high) {
        int[] left = Arrays.copyOfRange(index, low, mid + 1);
        int[] right = Arrays.copyOfRange(index, mid + 1, high + 1);
        int p = 0;
        int q = 0;
        int count = 0;
        int pos = low;

        while (p < left.length && q < right.length) {
            if (nums[left[p]] <= nums[right[q]]) {
                index[pos++] = left[p];
                counts[left[p++]] += count;
            } else {
                index[pos++] = right[q++];
                count++;
            }
        }

        while (p < left.length) {
            index[pos++] = left[p];
            counts[left[p++]] += count;
        }

        while (q < right.length) {
            index[pos++] = right[q++];
        }
    }
}
