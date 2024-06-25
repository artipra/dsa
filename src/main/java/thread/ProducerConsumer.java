package thread;

import java.util.ArrayList;


public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
     ArrayList<Integer> list = new ArrayList<>();

        Runnable r1 = () -> {
            //try {
                for (int i = 0; ; i++) {
                    System.out.println("adding " + i + Thread.currentThread().getName());
                    list.add(i);
                    //Thread.sleep(10000);
                }
           // }
//            catch (InterruptedException e){
//                e.printStackTrace();
//            }
        };
        Runnable r2 = () -> {
            for (int i = 0; ; i++) {
                System.out.println("removing  " + i + Thread.currentThread().getName());
                list.remove(Integer.valueOf(i));
            }
        };
     Thread producer = new Thread(r1);
     Thread consumer = new Thread(r2);

     producer.start();
     //
     consumer.start();
//        producer.join();
    }
}
