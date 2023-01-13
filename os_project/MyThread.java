public class MyThread implements Runnable {

    DataLibraries db;
    int numberRow;
    int numberColumn;

    MyThread(DataLibraries db,int  numberRow,int numberColumn) {
        this.db = db;
        this.numberRow = numberRow;
        this.numberColumn = numberColumn;
    }

    void setNumberRow(int numberRow) {
        this.numberRow = numberRow;
    }

    void setNumberColumn(int numberColumn) {
        this.numberColumn = numberColumn;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " run method worked...");

        try {
            db.semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " thread taked key...");

            synchronized (this.db) {

                System.out.println(Thread.currentThread().getName() + " thread in critical section...");

                for(int k=0;k<3;k++){
                    db.resultMatrix[numberRow][numberColumn] += db.firstMatrix[numberRow][k]*db.secondMatrix[k][numberColumn]; 
                }
                db.counter++;
                System.out.println(Thread.currentThread().getName() + " thread done its job...");
                System.out.println(numberRow + " " + numberColumn+" : "+db.resultMatrix[numberRow][numberColumn]);
                System.out.println("counter : " + db.counter);
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            System.out.println(Thread.currentThread().getName() + " thread release key...");
            db.semaphore.release();
        }

        if(db.counter == 4 && this.db.flag == false){
            this.db.flag = true; //bu bayrak yazma işlemini bir defa gerçekleştirmek için koydum
            Timer.stop();
            double seconds = Timer.getElapsedSeconds();
            System.out.println("\n\nGeçen süre " + seconds + " saniyedir" );
            printResultMatrix();
        }
    
    }

    public void printResultMatrix(){
        System.out.println("\n\nMatrix multiply with java threads --> Result Matrix \n\n");
        for(int i=0;i<db.resultMatrix.length;i++){
            for(int j=0;j<db.resultMatrix[i].length;j++){
                System.out.print(db.resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
