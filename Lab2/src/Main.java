
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(3);
        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 done.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 3; i++) {
                    executorService.submit(new MyThreads(Integer.toString(i + 2), countDownLatch));
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 5 done.");
            }
        }).start();


        countDownLatch.await();
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
