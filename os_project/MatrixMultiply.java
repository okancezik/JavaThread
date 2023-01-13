public class MatrixMultiply {
    
    int[][] firstMatrix;
    int[][] secondMatrix;
    int[][] resultMatrix;

    public MatrixMultiply(int[][] firstMatrix,int[][] secondMatrix,int[][] resultMatrix){
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
    }

    public void calculate(){
        for(int i=0;i<firstMatrix.length;i++){
            for(int j=0;j<secondMatrix[i].length;j++){
                for(int k=0;k<firstMatrix[i].length;k++){
                    this.resultMatrix[j][i] += this.firstMatrix[j][k] * this.secondMatrix[k][i];
                }
            }
        }
    }

    public void printResultMatrix(){
        System.out.println("\n\nMatrix multiply without java threads --> Result Matrix\n\n");
        for(int i=0;i<resultMatrix.length;i++){
            for(int j=0;j<resultMatrix[i].length;j++){
                System.out.print(resultMatrix[i][j]+"   ");
            }
            System.out.println();
        }
    }

}
