class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //count frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //sort
        List<Integer>[] freq = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (freq[count] == null) {
                freq[count] = new ArrayList<>();
            }
            freq[count].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0 && res.size() < k; i--) {
            if (freq[i] != null) {
                res.addAll(freq[i]);
            }
        }

        return res;
    }
}
