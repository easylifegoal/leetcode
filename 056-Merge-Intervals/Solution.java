class Solution {
    public int[][] merge(int[][] intervals) {
        int count = intervals.length;
        // if (count == 0) return intervals;

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= intervals[i][0]
                        && intervals[j][1] >= intervals[i][0]) {
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i][0] = -1;
                    count--;
                    break;
                } else if (intervals[i][0] <= intervals[j][0]
                          && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = intervals[i][0];
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i][0] = -1;
                    count--;
                    break;
                }
            }
        }

        int[][] ans = new int[count][];
        count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] != -1) {
                ans[count] = intervals[i];
                count++;
            }
        }

        return ans;
    }
}
