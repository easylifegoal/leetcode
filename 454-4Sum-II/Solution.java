class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A)
            for (int b : B) {
                int tmp = map.getOrDefault(a + b, 0);
                map.put(a + b, tmp + 1);
            }

        for (int c : C)
            for (int d : D) {
                int target = 0 - c - d;
                count += map.getOrDefault(target, 0);
            }

        return count;
    }
}
