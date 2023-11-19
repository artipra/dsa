package stream;

//stream interface seraching method
//allMatch(),anyMatch(),noneMatch(),findFirst(),findAny() - terminal +  short-circuiting-operation
// short-circuiting-operation as soon as the result is found, then the operation stops
//allMatch(),anyMatch(),noneMatch() takes predicate and return boolean
// if object needs to return use findAny() findFirst()

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchingOnStream {

    public static void main(String [] args){
     List<Dog> dogList = Arrays.asList(
             new Dog("boi",30,6),
             new Dog("clover",35,12),
             new Dog("aiko",50,10),
             new Dog("zooey",45,8),
             new Dog("charis",120,7)
             );

       //anyMatch()
        boolean anyMatch = dogList
                           .stream()
                           .filter(d -> d.getWeight() > 50)
                           .anyMatch(d -> d.getName().startsWith("c"));

        System.out.println("find any dog with > 50 and start with c "+anyMatch);


        //allMatch()
        boolean allMatch = dogList
                .stream()
                .mapToInt(Dog::getAge)
                .allMatch(d -> d > 5);

        System.out.println("all dogs age is  > 5 "+allMatch);



        //noneMatch()
        boolean noneMatch = dogList
                .stream()
                .map(Dog::getName)
                .noneMatch(d -> d.startsWith("red"));

        System.out.println("dog name start with red ? none found ? "+noneMatch);

        //findAny()
        Optional<String> findAny = dogList
                .stream()
                .map(Dog::getName)
                .filter(d -> d.equals("charis"))
                .findAny();

        System.out.println(" findAny()? "+findAny.orElse("false"));



        //findFirst()
        Optional<Dog> findFirst = dogList
                .stream()
                .filter(d -> d.getWeight() > 50)
                .findFirst();

        System.out.println(" findFirst()? "+findFirst.get());




    }
}
