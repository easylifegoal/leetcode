class Trie {
    class Node {
        Node[] child;
        String word;
        public Node() {
            child = new Node[26];
        }
    }

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node tmp = root;
        char[] chs = word.toCharArray();
        for (char ch : chs) {
            if (tmp.child[ch - 'a'] == null) {
                tmp.child[ch - 'a'] = new Node();
            }
            tmp = tmp.child[ch - 'a'];
        }
        tmp.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node tmp = root;
        char[] chs = word.toCharArray();
        for (char ch : chs) {
            if(tmp.child[ch - 'a'] == null) return false;
            tmp = tmp.child[ch - 'a'];
        }
        if (word.equals(tmp.word)) return true;

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node tmp = root;
        char[] chs = prefix.toCharArray();
        for (char ch : chs) {
            if(tmp.child[ch - 'a'] == null) return false;
            tmp = tmp.child[ch - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
