class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> begin = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        int distance = 1;
        begin.add(beginWord);
        while (!begin.contains(endWord)) {
            Set<String> reach = new HashSet<>();
            for (String word : begin) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chs = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chs[i] = ch;
                        String tmp = new String(chs);
                        if (dict.contains(tmp)) {
                            reach.add(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
            if (reach.isEmpty()) return 0;
            begin = reach;
            distance++;
        }

        return distance;
    }
}

//some improvement
class Solution {
    int count = 1;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dicts = new HashSet<>(wordList);
        if (!dicts.contains(endWord)) return 0;

        Set<String> starts = new HashSet<>();
        starts.add(beginWord);
        Set<String> ends = new HashSet<>();
        ends.add(endWord);

        return helper(starts, ends, dicts);
    }

    private int helper(Set<String> starts, Set<String> ends, Set<String> dicts) {
        if (starts.size() > ends.size()) return helper(ends, starts, dicts);

        dicts.removeAll(starts);
        Set<String> next = new HashSet<>();
        for (String word : starts) {
            for (int i = 0; i < word.length(); i++) {
                char[] chs = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chs[i] = ch;
                    String newWord = String.valueOf(chs);
                    if (dicts.contains(newWord)) {
                        if (ends.contains(newWord)) return count + 1;
                        next.add(newWord);
                    }
                }
            }
        }
        count++;

        if (next.isEmpty()) return 0;

        return helper(next, ends, dicts);
    }
}
