/**
 * my solution with twice loop
 */
class Solution {
    public int trap(int[] height) {
        int peak = 0;
        int weight = 0;
        int block = 0;
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] >= peak) {
                if (weight == 0) {
                    peak = height[i];
                } else {
                    result += peak * weight - block;
                    peak = height[i];
                    weight = 0;
                    block = 0;
                }
            } else {
                weight++;
                block += height[i];
            }
        }

        peak = 0;
        weight = 0;
        block = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > peak) {
                if (weight == 0) {
                    peak = height[i];
                } else {
                    result += peak * weight - block;
                    peak = height[i];
                    weight = 0;
                    block = 0;
                }
            } else {
                weight++;
                block += height[i];
            }
        }

        return result;
    }
}

/**
 * two pointer solution
 */
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int l = 0;
        int r = height.length - 1;
        int lmax = height[l];
        int rmax = height[r];
        int ans = 0;

        while (l < r) {
            if (lmax < rmax) {
                l++;
                if (lmax > height[l]) {
                    ans += lmax -height[l];
                } else {
                    lmax = height[l];
                }
            } else {
                r--;
                if (rmax > height[r]) {
                    ans += rmax -height[r];
                } else {
                    rmax = height[r];
                }
            }
        }

        return ans;
    }
}
