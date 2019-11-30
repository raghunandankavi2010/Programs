package programs.matrix;

public class SpiralTraversalMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2 ,3 ,4},
                {5 ,6 ,7 ,8 },
                {9, 10, 11, 12},
                {13 ,14 ,15 ,16}};
        
        int m = 4,n=4;
        matrixSpiralTraversal(matrix,m,n);
    }

    private static void matrixSpiralTraversal(int[][] matrix, int m, int n) {
         int i, start_row=0;
         int start_column=0;

         while(start_row<m && start_column<n){

             // print first row
             for(i=start_row;i<n;i++){
                 System.out.print(matrix[start_row][i]+" ");
             }
             start_row++; //printed first row increase start_row index
             // print first column
             for(i=start_row;i<m;i++){
                 System.out.print(matrix[i][m-1]+" ");
             }
             n--; // decrease end column index

             // print last row in reverse
             if (start_row < m) {
                 for (i = n-1; i >= 0; i--) {
                     System.out.print(matrix[m-1][i] + " ");
                 }
                 m--; // decrease row  end index
             }

             // print first column
             if (start_column < n) {
                 for (i = n-1; i >= start_row; i--) {
                     System.out.print(matrix[i][start_column] + " ");
                 }
                 start_column++; // increase start column index;
             }

         }
    }
}
