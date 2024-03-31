package thread;

import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;

public class ProducerConsumerSol2 {
    static final int size = 3;
    public static void main(String[] args) throws InterruptedException{
        PriorityBlockingQueue<Double> list = new PriorityBlockingQueue<>(2);

        Runnable r1 = () -> {
                while(true) {
                      double val = Math.random();
                            System.out.println("adding by  "+val +" "+ Thread.currentThread().getName());
                            list.put(val);
                        }
        };
        Runnable r2 = () -> {

            while(true) {
                try {
                    System.out.println("removing " + list.take() +" "+ Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread producer = new Thread(r1);
        Thread consumer = new Thread(r2);
        producer.start();
        consumer.start();
       producer.join();
       consumer.join();
    }
}