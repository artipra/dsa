package thread;

import java.util.concurrent.*;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // Scheduling a task to run with a fixed rate
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(
                new RunnableTask(), // Runnable task
                0,                  // Initial delay
                1,                  // Period
                TimeUnit.SECONDS    // Time unit
        );

        // Optionally, you can cancel the task after some time
       // executor.schedule(() -> future.cancel(true), 10, TimeUnit.SECONDS);

        // Shutdown the executor after a period of time
        executor.schedule(() -> executor.shutdown(), 15, TimeUnit.SECONDS);
    }

    static class RunnableTask implements Runnable {
        public void run() {
            System.out.println("Task running at " + System.currentTimeMillis() / 1000);
        }
    }
}
