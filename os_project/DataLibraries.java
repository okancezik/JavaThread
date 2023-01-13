import java.util.concurrent.Semaphore;

public class DataLibraries {
    
    int[][] firstMatrix;
    int[][] secondMatrix;
    int[][] resultMatrix;
    Semaphore semaphore = new Semaphore(1);
    int counter = 0;
    boolean flag = false;

    DataLibraries(int[][] firstMatrix , int[][] secondMatrix, int[][] resultMatrix){
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
    }
}
