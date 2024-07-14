package thread;

import java.util.ArrayList;


public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
     ArrayList<Integer> list = new ArrayList<>();
     int capcity = 2;

        Runnable r1 = () -> {
            //try {
                for (int i = 0; ; i++) {
                    if(list.size() < capcity) {
                        System.out.println("adding " + i + Thread.currentThread().getName());
                        list.add(i);
                    }
                }
        };
        Runnable r2 = () -> {
            for (int i = 0; ; i++) {
                if(list.size() >= capcity) {
                    System.out.println("removing  " + i + Thread.currentThread().getName());
                    list.remove(Integer.valueOf(i));
                }
            }
        };
     Thread producer = new Thread(r1);
     Thread consumer = new Thread(r2);

     producer.start();
     consumer.start();
     producer.join();
    }
}
