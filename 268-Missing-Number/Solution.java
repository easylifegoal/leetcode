class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = length * (length + 1) / 2;
        for (int i = 0; i < length; i++){
            sum = sum - nums[i];
        }

        return sum;
    }
}

//use bit
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }

        return res ^ nums.length;
    }
}
