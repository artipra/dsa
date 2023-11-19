package stream;

//stream's sort methods
// sorted() -- for natural sorting
//sorted(Comparator) - for user define object
//Comparator interface static method
// comparing() -- takes Function, whose functional method expects property
// on which to be stored and return comparator object
//reversed() -- return new comparator that has reverse ordering
//thenComparing() -- return a Comparator that compare first on you call it
// then by the Comparator you pass in
//distinct() -- return a stream with distinct value
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class SortingStream {

    public static void main(String [] args ){
      Stream<String> strings = Stream.of("Kramer","Elaine","jerry","George");
      strings.sorted().forEach(System.out::println);

    List<Duck> ducks = Arrays.asList(
            new Duck("jerry", "yellow", 3),
            new Duck("George", "brown", 4),
            new Duck("Kramer", "mottled", 6),
            new Duck("Elaine", "white", 2));
     //sorted(cComparator)
    ducks.stream().sorted().forEach(System.out::println);

    //another ways
        System.out.println("provides Comparator direct in sort method");
        ducks.stream().sorted((d1,d2) -> d1.getAge()-d2.getAge()).forEach(System.out::println);

      //creating comparator via lambda
        System.out.println("provides Comparator by age in sort method");
        Comparator<Duck> byAgeLambda = (d1,d2) -> d1.getAge() -d2.getAge();
        ducks.stream().sorted(byAgeLambda).forEach(System.out::println);

        Comparator<Duck> byColor = Comparator.comparing(Duck::getColor);
        Comparator<Duck> byName = Comparator.comparing(Duck::getName);
        Comparator<Duck> byAge = Comparator.comparing(Duck::getAge);
        System.out.println("by age");
        ducks.stream().sorted(byAge).forEach(System.out::println);
        System.out.println("reversed---");
        ducks.stream().sorted(byAge.reversed()).forEach(System.out::println);

        ducks = new ArrayList<>();
        ducks.add(new Duck("George", "brown", 4));
        ducks.add(new Duck("Kramer", "mottled", 6));
        ducks.add(new Duck("Elaine", "white", 2));
        ducks.add(new Duck("George", "brown", 4));
        ducks.add(new Duck("Kramer", "mottled", 6));
        ducks.add(new Duck("Elaine", "white", 2));

        ducks.stream().map(d -> d.getColor()).distinct().forEach(System.out::println);







    }
}
