class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int h = 0;
        int w = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            w = r - l;
            if (height[l] < height[r]) {
                h = height[l];
                l++;
            } else {
                h = height[r];
                r--;
            }
            max =  w * h > max ? w * h : max;
        }

        return max;
    }
}
