package thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread implements Callable<Integer> {

    Lock lock = new ReentrantLock();

    @Override
    public Integer call() {
            lock.lock();
            for(int i=0; i<100; i++){
                System.out.println(i);
            }
            set1();
            return 1;
    }

    void set1(){
        System.out.println(Thread.currentThread().getName()+" is done");
        lock.unlock();
    }
}
public class ReentrantDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> c1 = new MyThread();
        Callable<Integer> c2 = new MyThread();
        Callable<Integer> c3 = new MyThread();
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = ex.submit(c1); ex.submit(c2);ex.submit(c3);
        System.out.println("future of c1 "+f1.get());
        ex.shutdown();

    }
}
