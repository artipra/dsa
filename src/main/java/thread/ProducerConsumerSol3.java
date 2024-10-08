package thread;

import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerSol3 {

        static final int size = 3;
        public static void main(String[] args) throws InterruptedException{
            LinkedList<Double> list = new LinkedList<>();
            Semaphore semprod = new Semaphore(1);
//            Semaphore semcon = new Semaphore(2);
            Runnable r1 = () -> {
                while(true) {
                    try {
                        semprod.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    while(list.size() < 5){
                        double val = Math.random();
                        list.add(val);
                        System.out.println("adding by  "+val +" "+ Thread.currentThread().getName());
                    }
                    semprod.release();
                }
            };
            Runnable r2 = () -> {

                while(true) {

                    try {
                        semprod.acquire();
                        double val =0;
                        while(list.size() > 0){
                            val = list.removeFirst();
                        System.out.println("removing " + val +" "+ Thread.currentThread().getName());
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    semprod.release();
                }
            };
            Thread producer = new Thread(r1);
            Thread consumer = new Thread(r2);
            Thread producer1 = new Thread(r1);
            Thread consumer1 = new Thread(r2);
            producer.start();
            consumer.start();
            producer1.start();
            consumer1.start();
//            producer.join();
//            consumer.join();
        }
    }

