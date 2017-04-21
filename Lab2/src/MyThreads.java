import java.util.concurrent.CountDownLatch;

/**
 * Created by schiduvasile on 4/6/17.
 */
public class MyThreads implements Runnable {
    private CountDownLatch countDownLatch;
    private String threadName;

    public MyThreads(String threadName, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.threadName = threadName;
    }


    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + threadName + " done.");

        countDownLatch.countDown();
    }
}
