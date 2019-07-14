/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * bfs solution
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;

        while (queue.peek() != null) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                list.add(node.val);
            }
            if (flag == 0) {
                flag = 1;
            } else {
                int length = list.size() >> 1;
                for (int i = 0; i < length; i++) {
                    int tmp = list.get(i);
                    list.set(i, list.get(list.size() - i - 1));
                    list.set(list.size() - i - 1, tmp);
                }
                flag = 0;
            }
            ans.add(list);
        }

        return ans;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * dfs solution
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        build(ans, root, 0);
        return ans;
    }

    void build(List<List<Integer>> list, TreeNode node, int height) {
        if (node == null) return;

        if (list.size() == height)
            list.add(new LinkedList<>());
        if (height % 2 == 0)
            list.get(height).add(node.val);
        else
            ((LinkedList)list.get(height)).addFirst(node.val);
        build(list, node.left, height + 1);
        build(list, node.right, height + 1);

    }
}
