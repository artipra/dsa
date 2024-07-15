package thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Producer implements Runnable {
    private List<String> buffer;

    public Producer(List<String> buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        String numbers[] = {"1", "2", "3"};
        for (String number : numbers) {
            buffer.add(number);
            System.out.println(Thread.currentThread().getName() + " added " + number);
        }
    }
}
class Consumer implements Runnable{
        private List<String> buffer;

        public Consumer(List<String> buffer) {
            this.buffer = buffer;
        }
        @Override
        public void run() {
            while (true){
                    System.out.println(Thread.currentThread().getName()+ " removed " +buffer.remove(0));
                }
            }

}

public class ProducerConsumer {
    public static final String EOF = "EOF";
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();

        Thread producerThread = new Thread(new Producer(buffer));
        producerThread.setName("producerThread");

        Thread consumerThread1 = new Thread(new Consumer(buffer));
        consumerThread1.setName("consumerThread1");

        Thread consumerThread2 = new Thread(new Consumer(buffer));
        consumerThread2.setName("consumerThread2");

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
