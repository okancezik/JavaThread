public class Timer {
    
    private static long start;
    private static long end;
    private static boolean started;

    private static boolean isStopped() {
        return !started;
    }

    private static boolean isStarted() {
        return started;
    }

    //Kronometreyi başlatır.
    public static void start() {
        if (isStopped()) {
            startTimer();
        } else {
            throw new RuntimeException("Hata: Kronometre (Timer) zaten başlatılmış durumda!!!\n");
        }
    }

    private static void startTimer() {
        start = System.nanoTime();
        started = true;
    }

    //Kronometreyi durdurur.     
    public static void stop() {
        if (isStarted()) {
            stopTimer();
        } else {
            throw new RuntimeException("Hata: Kronometre (Timer) başlatılmadı!!!\n");
        }
    }

    private static void stopTimer() {
        end = System.nanoTime();
        started = false;
    }

    //Timer.start() ile Timer.stop() arasında geçen süreyi nanosaniye olarak döndürür.     
    public static long getElapsedTime() {
        if (isStopped()) {
            return end - start;
        } else {
            throw new RuntimeException("Hata: Kronometre (Timer) durdurulmadı!!!\n");
        }

    }

    //Timer.start() ile Timer.stop() arasında geçen süreyi saniye cinsinden döndürür.
    public static double getElapsedSeconds() {
        double seconds = (double) getElapsedTime() / 1000000000.0;
        return seconds;
    }  
}