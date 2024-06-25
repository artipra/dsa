package thread;

import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerSol3 {

        static final int size = 3;
        public static void main(String[] args) throws InterruptedException{
            LinkedList<Double> list = new LinkedList<>();
            Semaphore semprod = new Semaphore(1);
            Semaphore semcon = new Semaphore(1);
            Runnable r1 = () -> {
                while(true) {
                    try {
                        semprod.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    double val = Math.random();
                    System.out.println("adding by  "+val +" "+ Thread.currentThread().getName());
                    while(list.size() < 5)list.add(val);
                    semprod.release();
                }
            };
            Runnable r2 = () -> {

                while(true) {

                    try {
                        semprod.acquire();
                        double val =0;
                        if(list.size() > 0)val = list.removeFirst();
                        System.out.println("removing " + val +" "+ Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    semprod.release();
                }
            };
            Thread producer = new Thread(r1);
            Thread consumer = new Thread(r2);
            producer.start();
            consumer.start();
//            producer.join();
//            consumer.join();
        }
    }

