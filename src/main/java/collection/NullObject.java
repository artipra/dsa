package collection;
import java.util.*;
import java.util.concurrent.*;

public class NullObject {

    public static void main(String[] args) throws InterruptedException{
        HashMap<Integer,Integer> set = new HashMap();
        Integer i = 10000;
        Integer i2 = 10000;
        set.put(i,28);
        set.put(i2,28);

        System.out.println(set);
    }
}
