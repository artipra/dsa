package thread;

public class Deadlock {


    public static void main(String args[]){
        Integer obj1 = 10;
        Integer obj2 = 8;

        Runnable r1 = () -> {
            synchronized(obj1){
                System.out.println("lock on obj1 accquired "+Thread.currentThread().getName());

                synchronized(obj2){
                    System.out.println("lock on obj2 accquired "+Thread.currentThread().getName());
                }
            }
        };

        Runnable r2 = () -> {
            synchronized(obj2){
                System.out.println("lock on obj2 accquired "+Thread.currentThread().getName());

                synchronized(obj1){
                    System.out.println("lock on obj1 accquired "+Thread.currentThread().getName());
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();


    }

}
