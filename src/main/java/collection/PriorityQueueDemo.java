package collection;

import lombok.Setter;
import lombok.ToString;

import java.util.*;
@ToString
class MyKey{
    String name;
    MyKey(String name){
        this.name = name;
    }
    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        MyKey user = (MyKey) o;
        return name == user.name;
    }

}
public class PriorityQueueDemo {

    public static void main(String[] args) {
        HashMap<MyKey,String> myHashMap = new HashMap();

        //MyKey name argument passed is used for equals() and hashCode()
        MyKey key = new MyKey("Pankaj"); //assume hashCode=1234
        myHashMap.put(key, "Value");

        // Below code will change the key hashCode() and equals()
        // but its location is not changed.
//        key.setName("Amit"); //assume new hashCode=7890

        MyKey key1 = new MyKey("nnn"); //assume hashCode=1234
        myHashMap.put(key1, "Vale");

        //below will return null because HashMap will try to look for key
        //in the same index as it was stored but since the key is mutated,
        //there will be no match and it will return null.
        String value = myHashMap.get(new MyKey("Pankaj"));
        System.out.println(myHashMap);

    }


}
