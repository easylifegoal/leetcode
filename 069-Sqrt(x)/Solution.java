class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int low = 1;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid > x / mid) {
                high = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) return mid;
                low = mid + 1;
            }
        }

        return -1;
    }
}
