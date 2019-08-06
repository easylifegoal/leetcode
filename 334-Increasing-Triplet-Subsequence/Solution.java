class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > n2) return true;
            if (num > n1) n2 = num;
            else n1 = num;
        }

        return false;
    }
}
