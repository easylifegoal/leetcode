class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            char[] category = new char[26];
            for (char ch : chs) {
                category[ch - 'a']++;
            }
            String key = new String(category);
            if (!map.containsKey(key))
                map.put(key, new LinkedList<String>());
            map.get(key).add(str);
        }

        return new LinkedList(map.values());
    }
}
