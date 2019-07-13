/**
 * merge solution
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return (nums2[((nums2.length + 1) >> 1) - 1]
                + nums2[((nums2.length + 2) >> 1) - 1]) / 2.0;
        if (nums2.length == 0)
            return (nums1[((nums1.length + 1) >> 1) - 1]
                + nums1[((nums1.length + 2) >> 1) - 1]) / 2.0;

        int[] tmp = new int[(nums1.length + nums2.length + 2) >> 1];

        int ptr1 = 0;
        int ptr2 = 0;
        int index = 0;
        while (index < tmp.length && ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] < nums2[ptr2]) {
                tmp[index] = nums1[ptr1];
                ptr1++;
            } else {
                tmp[index] = nums2[ptr2];
                ptr2++;
            }
            index++;
        }

        while (index < tmp.length && ptr1 < nums1.length) {
            tmp[index] = nums1[ptr1];
            ptr1++;
            index++;
        }

        while (index < tmp.length && ptr2 < nums2.length) {
            tmp[index] = nums2[ptr2];
            ptr2++;
            index++;
        }

        return ((tmp[((nums1.length + nums2.length + 1) >> 1) - 1])
            + (tmp[((nums1.length + nums2.length + 2) >> 1) - 1])) / 2.0;
    }
}

/**
 * binary search
 * https://www.youtube.com/watch?v=LPFhl65R7ww
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //if nums1 length greater than nums2 switch them
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0;
        int end = x;

        while (start <= end) {
            int partitionX = start + ((end - start) >> 1);
            int partitionY = ((x + y + 1) >> 1) - partitionX;

            int leftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int rightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            int leftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int rightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if (leftX <= rightY && rightX >= leftY) {
                if ((x + y) % 2 == 0)
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                return (double) Math.max(leftX, leftY);
            } else if (leftX > rightY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }

        return 0;
    }
}
