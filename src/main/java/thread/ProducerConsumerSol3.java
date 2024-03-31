package thread;

import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerSol3 {

        static final int size = 3;
        public static void main(String[] args) throws InterruptedException{
            LinkedList<Double> list = new LinkedList<>();
            Semaphore semprod = new Semaphore(0);
            Semaphore semcon = new Semaphore(0);
            Runnable r1 = () -> {
                while(true) {
                    try {
                        semprod.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    double val = Math.random();
                    System.out.println("adding by  "+val +" "+ Thread.currentThread().getName());
                    list.add(val);
                    semprod.release();
                }
            };
            Runnable r2 = () -> {

                while(true) {

                    try {
                        semcon.acquire();
                        System.out.println("removing " + list.removeFirst() +" "+ Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    semcon.release();
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

