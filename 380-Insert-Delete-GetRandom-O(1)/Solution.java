class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    //index pointer for that we will not to delete list data
    int listIndex;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.listIndex = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        if (listIndex < list.size()) {
            map.put(val, listIndex);
            list.set(listIndex, val);
        } else {
            map.put(val, list.size());
            list.add(val);
        }
        listIndex++;

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val);
        if (index < listIndex - 1) {
            int last = list.get(listIndex - 1);
            int temp = list.get(index);
            list.set(index, last);
            list.set(listIndex - 1, temp);
            map.put(last, index);
        }
        listIndex--;
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (listIndex == 0) return 0;
        int random = (int) (Math.random() * listIndex);

        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
