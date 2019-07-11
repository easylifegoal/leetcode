class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;

        int[][] flag = new int[matrix.length][matrix[0].length];
        move(ans, matrix, flag, 0, 0);
        return ans;
    }

    void move(List<Integer> list, int[][] matrix, int[][] flag, int i, int j) {
        if (flag[i][j] == 1)
            return;

        list.add(matrix[i][j]);
        flag[i][j] = 1;
        //right
        while (j + 1 < matrix[0].length && flag[i][j + 1] == 0) {
            j++;
            list.add(matrix[i][j]);
            flag[i][j] = 1;
        }
        //down
        while(i + 1 < matrix.length && flag[i + 1][j] == 0) {
            i++;
            list.add(matrix[i][j]);
            flag[i][j] = 1;
        }
        //left
        while(j - 1 >= 0 && flag[i][j - 1] == 0) {
            j--;
            list.add(matrix[i][j]);
            flag[i][j] = 1;
        }
        //up
        while(i - 1 >= 0 && flag[i - 1][j] == 0) {
            i--;
            list.add(matrix[i][j]);
            flag[i][j] = 1;
        }

        if (j + 1 < matrix[0].length)
            move(list, matrix, flag, i, j + 1);
    }
}
