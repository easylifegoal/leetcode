class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int index = 0;
        //construct adjacency list
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        //count in-degree
        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
            adj[pair[1]].add(pair[0]);
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            res[index] = vertex;
            index++;
            for (int i = 0; i < adj[vertex].size(); i++) {
                int key = adj[vertex].get(i);
                inDegree[key]--;
                if (inDegree[key] == 0) queue.offer(key);
            }
        }

        //verify circle
        for (int vertex : inDegree) {
            if (vertex != 0) return new int[0];
        }

        return res;
    }
}
