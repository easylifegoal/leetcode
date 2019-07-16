class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] ans = new int[Math.min(nums1.length, nums2.length)];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ptr1 = 0;
        int ptr2 = 0;
        int index = 0;

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                ans[index] =nums1[ptr1];
                ptr1++;
                ptr2++;
                index++;
            } else if (nums1[ptr1] > nums2[ptr2]) {
                ptr2++;
            } else {
                ptr1++;
            }
        }

        return Arrays.copyOf(ans, index);
    }
}
