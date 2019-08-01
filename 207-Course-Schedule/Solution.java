// use topological sort
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            adj[pair[1]].add(pair[0]);
            inDegree[pair[0]]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < adj[i].size(); j++) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) queue.offer(k);
            }
        }

        for (int i : inDegree) {
            if (i != 0) return false;
        }

        return true;
    }
}
