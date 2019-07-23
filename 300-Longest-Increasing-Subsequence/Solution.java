//dp solution with O(n^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] counts = new int[nums.length];
        counts[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    tmp = Math.max(counts[j], tmp);
            }
            counts[i] = tmp + 1;
            max = Math.max(max, counts[i]);
        }

        return max;
    }
}


//solution with O(nlogn)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            //index means current longest increasing subsequence at the num
            int index = search(dp, 0, len - 1, num);
            dp[index] = num;
            if (index == len) len++;
        }

        return len;
    }

    private int search(int[] dp, int low, int high, int key) {
       while (low <= high) {
           int mid = low + ((high - low) >> 1);
           if (dp[mid] >= key) {
               if (mid == 0 || dp[mid - 1] < key) return mid;
               high = mid - 1;
           } else {
               low = mid + 1;
           }
        }

        return low;
    }
}
