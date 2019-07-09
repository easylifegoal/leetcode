class Solution {
    public void setZeroes(int[][] matrix) {
        int firstRow = 1;
        int firstCol = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = 0;
                    if (j == 0) firstCol = 0;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Row
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        //Col
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRow == 0) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }

        if (firstCol == 0) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}lass Solution {
    public void setZeroes(int[][] matrix) {
        int firstRow = 1;
        int firstCol = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = 0;
                    if (j == 0) firstCol = 0;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Row
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        //Col
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRow == 0) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }

        if (firstCol == 0) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
