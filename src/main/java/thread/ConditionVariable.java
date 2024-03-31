package thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionVariable {
    static final int size = 2;
    ArrayList<Integer> list = new ArrayList();
    static Lock lock = new ReentrantLock();
    static Condition empty = lock.newCondition();
    static Condition full = lock.newCondition();

     void producer() throws InterruptedException{
        lock.lock();
        if(list.size() == size){
            System.out.println("queue is full let's wait");
            full.await();
        }

        else {
            System.out.println("Time to produce................");
            while(list.size() != size){

            }
            Random rand = new Random();
            list.add(rand.nextInt());
        }

    }

    void Consumer() throws InterruptedException {
        lock.lock();
        if(list.size() == 0){
            System.out.println("queue is empty... lets wait to get items");
            empty.await();
        }
        else {
           while(list.size() != 0){
               list.remove(0);
           }
           full.signal();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Runnable r = null;
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();

    }
}
