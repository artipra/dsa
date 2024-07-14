package thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerSol1 {
    static final int size = 3;
    public static void main(String[] args) {
        LinkedList<Double> list = new LinkedList<>();

        Runnable r1 = () -> {
            try {
                while(true) {
                    synchronized (list) {
                        if (list.size() == size) list.wait();
                        else {
                            double val = Math.random();
                            System.out.println("adding by  "  + val +"  " +Thread.currentThread().getName());
                            list.add(val);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {

            while(true) {
                synchronized (list) {
                    if (list.size() == 0) list.notify();
                    else {
                        System.out.println("removing " + list.removeFirst() +" "+ Thread.currentThread().getName());
                    }
                }
            }
        };
        Thread producer = new Thread(r1);
        Thread consumer = new Thread(r2);
        producer.start();
        consumer.start();

    }
}