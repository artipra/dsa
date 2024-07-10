package generic;

import java.util.ArrayList;

class Generic<T>{

    T obj;

    Generic(T obj){
        this.obj = obj;
    }

    public void show(){
        System.out.println("the type of obj is "+obj.getClass().getName());
    }

    public T getObj(){
        return obj;
    }
}


public class GenericDemo {
    public static void main(String[] args) {
        Generic<String> strclass = new Generic("string obj");
        strclass.show();

        Generic<Long> strLong = new Generic(1L);
        strLong.show();
        Generic<Integer> strInt = new Generic(10);
        strInt.show();
//        ArrayList arr = new ArrayList<>();
//        arr.add(12);
//        arr.add("dsjhfgdsj");
//        arr.add(null);
//        arr.stream().forEach(a -> a.hashCode());
    }

    public void set() {
        int a = 0;
        synchronized (this) {
            a = 10;

        }
    }

}