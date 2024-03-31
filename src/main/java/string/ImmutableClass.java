package string;

import lombok.Getter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//What is immutablity
//How it is implemented in java
//How can create our own immutable class -
// 1 make class final so on one can change it functionality,
// 2 make all variable as private to restrict accessbility + no setter methods to change object state once created
// 3 all mutating variable should be created by deep copy

final public class ImmutableClass {
  private String name;
  private ArrayList<Integer> list;

  ImmutableClass(String name,ArrayList<Integer> list){
      this.name = name;
       list = new ArrayList<>();
      // Iterating using for-each loop
      for (int a : list) {
          list.add(a);
      }
      this.list = list;
  }

  public String getName(){
      return name;
  }

  public ArrayList<Integer> getList(){
      ArrayList<Integer> list1 = new ArrayList<>();
      list1.add(list.get(0));
      list1.add(list.get(1));
      return list1;

  }
  public String toString(){
      return this.name+" "+list;
  }
}
