public class os_project{
    public static void main(String[] args) throws InterruptedException {
        
        int[][] firstMatrix = {{1,2,3},{4,5,6}};
        int[][] secondMatrix = {{1,2},{3,4},{5,6}};
        int[][] resultMatrix = new int[2][2];

        DataLibraries db = new DataLibraries(firstMatrix, secondMatrix,resultMatrix);

        Thread[] threads = new Thread[4];

        threads[0] = new Thread(new MyThread(db,0,0));
        threads[1] = new Thread(new MyThread(db,0,1));
        threads[2] = new Thread(new MyThread(db,1,0));
        threads[3] = new Thread(new MyThread(db,1,1));
  
        //COMMEND LINE --> matrix multiply with java threads
        Timer.start();
        for(int i=0;i<4;i++){
            threads[i].start();
        }
        
        //COMMEND LINE --> matrix multiply without java threads
        // Timer.start();
        // MatrixMultiply matrixMultiply = new MatrixMultiply(firstMatrix, secondMatrix, resultMatrix);
        // matrixMultiply.calculate();
        // Timer.stop();
        // double seconds = Timer.getElapsedSeconds();
        // System.out.println("\n\nGeçen süre " + seconds + " saniyedir" );
        // matrixMultiply.printResultMatrix();
    }
}