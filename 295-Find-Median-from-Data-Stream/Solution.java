// two heap
class MedianFinder {
    Queue<Integer> maxQ;
    Queue<Integer> minQ;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxQ = new PriorityQueue<>(Collections.reverseOrder());
        minQ = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxQ.size() == 0 || maxQ.peek() > num) {
            maxQ.offer(num);
        } else {
            minQ.offer(num);
        }

        //balance
        if (minQ.size() > maxQ.size()) {
            maxQ.offer(minQ.poll());
        }

        if (maxQ.size() - minQ.size() > 1) {
            minQ.offer(maxQ.poll());
        }
    }

    public double findMedian() {
        if (maxQ.size() > minQ.size()) return maxQ.peek();

        return (minQ.peek() - maxQ.peek()) / 2.0 + maxQ.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


 //insertion sort
class MedianFinder {
    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int l = 0;
        int r = list.size() - 1;
        int index = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (list.get(mid) >= num) {
                if (mid == 0 || list.get(mid - 1) < num) {
                    index = mid;
                    break;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        list.add(index, num);
    }

    public double findMedian() {
        Collections.sort(list);
        int length = list.size();
        int n1 = length >> 1;
        int n2 = (length - 1) >> 1;

        return list.get(n2) + (list.get(n1) - list.get(n2)) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
