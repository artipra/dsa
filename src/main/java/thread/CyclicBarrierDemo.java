package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    CyclicBarrier barrier;
    String[] str1 = {"boi","cloveer","char"};
    String[] str2 = {"aioi","zokey","biscuit"};
    List<String> result = new ArrayList<>();

    class ProcessDogs implements Runnable{
        String dogs[];
        ProcessDogs(String[] d){ dogs =d; }
        public void run(){
            for(int i=0; i<dogs.length; i++){
                dogs[i] = dogs[i].toUpperCase();
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" worker thread is done! ");
        }
    }

    public CyclicBarrierDemo(){

        barrier = new CyclicBarrier(2 , ()-> {
            for(int i=0; i<str1.length; i++){
                result.add(str1[i]);
            }
            for(int i=0; i<str2.length; i++){
                result.add(str2[i]);
            }
            System.out.println(Thread.currentThread().getName()+" is last thread");
        });
        Thread t1 = new Thread(new ProcessDogs(str1));
        Thread t2 = new Thread(new ProcessDogs(str2));
        t1.start();
        t2.start();
       // System.out.println("Main Thread is done!!!");
    }
    public static void main(String[] args) {
        CyclicBarrierDemo d1 = new CyclicBarrierDemo();
    }
}
