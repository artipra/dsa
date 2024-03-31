package thread;

import java.util.ArrayList;


public class ProducerConsumer {
    public static void main(String[] args) {
     ArrayList<Integer> list = new ArrayList<>();

        Runnable r1 = () -> {
            for (int i =0; i<100; i++) {
                System.out.println("adding " + i + Thread.currentThread().getName());
                list.add(i);
            }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            for (int i = 0; ; i++) {
                System.out.println("removing  " + i + Thread.currentThread().getName());
                list.remove(i);
            }
        };
     Thread producer = new Thread(r1);
     Thread consumer = new Thread(r2);
     producer.start();
     consumer.start();
    }
}
