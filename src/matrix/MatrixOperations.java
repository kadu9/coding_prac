package matrix;

public class MatrixOperations {

    public void sumMiddleRowAndColumn(int[][] mat){
        int rowSum=0,colSum=0;
        for (int i = 0; i < mat.length; i++) {
            rowSum = rowSum + mat[mat.length/2][i];
        }
        for (int i = 0; i < mat.length; i++) {
            colSum = colSum + mat[i][mat.length/2];
        }
        System.out.println("RowSum :"+rowSum+" ColSum: "+colSum);
    }

    public  void printInZForm(int[][] mat){
        int m = mat[0].length-1;
        int n = mat.length;


        // print first row
        for (int i = 0; i < n; i++)
            System.out.println(mat[0][i]);// << " ";

        // Print diagonal
        int i = 1, j = n - 2;
        while (i < n && j >= 0) // print diagonal
        {
            System.out.println(mat[i][j]);// << " ";
            i++;
            j--;
        }

        // Print last row
        for ( i = 1; i < n; i++)
            System.out.println(mat[n-1][i]);// << " ";
        }

        public void sparseMatrixMultiplication(int[][] a, int[][] b){
        int[][] c = new int[a.length][b[0].length];

        for (int i=0;i<c.length;i++){
            for(int j=0; j<c[0].length-1; j++){
                for(int k =0 ;k<a[0].length;k++){
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
            }
        }

        public void rotateBy90ClockWise(int[][] matrix){

            //transpose
            for(int i = 0; i<matrix.length; i++){
                for(int j = i; j<matrix[0].length; j++){
                    int temp = 0;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            System.out.println("after transpose");
            displayMatrix(matrix);
            for(int i =0 ; i<matrix.length; i++){
                for(int j = 0; j<matrix.length/2; j++){
                    int temp = 0;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length-1-j];
                    matrix[i][matrix.length-1-j] = temp;
                }
            }
        displayMatrix(matrix);

        }

    public void rotateBy90AntiClockWise(int[][] matrix){

        //transpose
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("after transpose");

        displayMatrix(matrix);
        //for anti clockwise , flipt vrows vertically
        for(int j =0 ; j<matrix.length; j++){
            for(int i = 0; i<matrix.length/2; i++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }
        displayMatrix(matrix);
    }

    static void displayMatrix( int mat[][])
    {
        int N = mat.length;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }


    public void printSpiralMatrix(int[][] matrix){
        if (matrix.length==0) return;
        int rowBegin=0;
        int rowEnd= matrix.length-1;
        int colBegin=0;
        int colEnd=matrix.length-1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //traverse right

            for (int i = colBegin ; i <= colEnd ; i++) {
                System.out.print(matrix[rowBegin][i]);
            }
            rowBegin++;
            //traverse bottom;
            for (int j=rowBegin; j<= rowEnd; j++){
                System.out.print(matrix[j][colEnd]);
            }
            colEnd--;

            //traverse left
            if(rowBegin <= rowEnd){
                for(int j=colEnd;j>=colBegin;j--){
                    System.out.print(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if(colBegin <=colEnd){
                for (int j=rowEnd; j>=rowBegin; j--){
                    System.out.print(matrix[j][colBegin]);
                }
            }
            colBegin++;


        }

    }
    public static void main(String[] args){
        MatrixOperations matrixOperations = new MatrixOperations();
        int[][] m ={{1,9,3,4},
                    {4,5,6,5},
                    {7,8,9,2},
                    {8,6,7,11}
                    };
       // matrixOperations.sumMiddleRowAndColumn(m);
       // matrixOperations.printInZForm(m);
       // matrixOperations.rotateBy90ClockWise(m);
        //  matrixOperations.rotateBy90AntiClockWise(m);
        matrixOperations.printSpiralMatrix(m);



    }

}
