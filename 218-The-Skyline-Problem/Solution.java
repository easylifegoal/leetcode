/**
 * use treemap, divide to two events, one is entering event, another one is
 * leaving event
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heights, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int prev = 0;
        map.put(0, 1);
        for (int[] h : heights) {
            if(h[1] < 0) {
                int count = map.getOrDefault(-h[1], 0) + 1;
                map.put(-h[1], count);
            } else {
                int count = map.get(h[1]);
                if (count == 1) {
                    map.remove(h[1]);
                } else {
                    map.put(h[1], count - 1);
                }
            }

            int cur = map.firstKey();
            if (prev != cur) {
                ans.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }

        return ans;
    }
}
