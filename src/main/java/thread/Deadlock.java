package thread;

public class Deadlock {

     synchronized void set1(){
        System.out.println("class level 11111 lock"+Thread.currentThread().getName());
//         Thread.sleep(10000);
    }

    synchronized void set2() throws InterruptedException {
        System.out.println("class level 2222 lock"+Thread.currentThread().getName());
        Thread.sleep(10000);
    }


    public static void main(String args[]){

//
//        Integer obj1 = 10;
//        Integer obj2 = 8;
//
        Deadlock d1 = new Deadlock();
        Runnable r1 = () -> {
        d1.set1();
            try {
                d1.set2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable r2 = () -> {
            d1.set1();
            try {
                d1.set2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
//
//        Runnable r2 = () -> {
//            synchronized(obj2){
//                System.out.println("lock on obj2 accquired "+Thread.currentThread().getName());
//
//                synchronized(obj1){
//                    System.out.println("lock on obj1 accquired "+Thread.currentThread().getName());
//                }
//            }
//        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();


    }

}
