package programs.matrix;

/**https://leetcode.com/contest/weekly-contest-162/problems/cells-with-odd-values-in-a-matrix/
 * Input: n = 2, m = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]]
 * [0 0 0]
 * [0 0 0]
 * 1252. Cells with Odd Values in a Matrix
 */
public class OddCellsmatrix {

    public static void main(String[] args) {
        int n=2;
        int m=3;
        int[][] matrix =new int[n][m];
        int[][] indices = {
                {0, 1},
                {1,1}
        };

        for(int i=0;i<indices.length;i++){
            for(int j=0;j<indices[i].length;j++){
                if(j==1){
                    addMatrixColumn(indices[i][j],matrix);
                }else {
                    addMatrixRow(indices[i][j], matrix);
                }
            }
        }

        printMatrix(matrix);

   }

    private static void addMatrixRow(int row, int[][] matrix) {
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i] = matrix[row][i]+1;
        }
    }

    private static void addMatrixColumn(int column, int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            matrix[i][column] = matrix[i][column]+1;
        }

    }

    private static void printMatrix(int[][] matrix){
        int count =0;
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] % 2 != 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
