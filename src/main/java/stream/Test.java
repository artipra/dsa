package stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.averagingInt;

class Test{

    public static void main(String [] args) {
//        1. Write a Java program to calculate the average of a list of integers using streams.
          List<Integer> list1 = Arrays.asList(1,2,3);
          OptionalDouble op1 = list1.stream().mapToInt(i ->i).average();
          OptionalDouble op2 = list1.stream().mapToInt(Integer::intValue).average();
          Double op3 = list1.stream().mapToInt(Integer::intValue).average().orElse(0.0);
          OptionalDouble op4 = list1.stream().mapToDouble(Integer::doubleValue).average();
          Double op5 = list1.stream().collect(Collectors.averagingInt(Integer::intValue));
          System.out.println(op5);

//        2. Write a Java program to convert a list of strings to uppercase or lowercase using streams.
          List<String> list2 = Arrays.asList("a","b","c","d","c");
          list2.stream().map(String::toUpperCase).forEach(System.out::print);
          list2.stream().map(s -> s.toLowerCase()).forEach(System.out::println);

//        3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
          List<Integer> list3 = Arrays.asList(1,2,3,4);
          double sumEven = list3.stream().filter( i ->i%2==0).mapToDouble(Integer::doubleValue).sum();
          int sumOdd = list3.stream().filter( i ->i%2!=0).mapToInt(Integer::intValue).sum();
          System.out.println(sumEven +" "+sumOdd);

//        4. Write a Java program to remove all duplicate elements from a list of integer using streams.
        List<Integer> list4 = Arrays.asList(1,2,3,1,2,2);
        list4.stream().distinct().forEach(System.out::println);
        Set<Integer> set1 = list4.stream().collect(Collectors.toSet());
        System.out.println(set1);

//        5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.
        List<String> list5 = Arrays.asList("dnb","acb","lop","aaa","abc","alpo");
        long res1 = list5.stream().filter(s -> s.startsWith("a")).count();
        System.out.println(res1);

//        6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
        List<String> list6 = Arrays.asList("dnb","acb","lop","aaa","abc","alpo");
        List<String> res3 =  list6.stream().sorted().collect(Collectors.toList());
        System.out.println(res3);
        List<String> res2 = list6.stream().sorted((s1,s2) ->  -s1.compareTo(s2)).collect(Collectors.toList());
        System.out.println(res2);
        List<String> res4 = list6.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(res4);

//        7. Write a Java program to find the maximum and minimum values in a list of integers using streams.
        List<Integer> list7 = Arrays.asList(1,3,6,9,2,7,8,18);
        OptionalInt op6 = list7.stream().mapToInt(Integer::intValue).min();
        Optional<Integer> op7 = list7.stream().collect(Collectors.maxBy((o1,o2) -> o1.intValue() - o2.intValue()));
        Optional<Integer> op8 = list7.stream().max(Integer::compare);
        Integer op9 = list7.stream().max(Integer::compare).orElse(0);
        System.out.println(op6 +" "+ op7 +" "+ op8+" "+op9);

//        8. Write a Java program to find the second smallest and largest elements in a list of integers using streams.
        List<Integer> list8 = Arrays.asList(1,2,3,4,6,8,-1);
        Optional<Integer> op10 = list8.stream().sorted().skip(1).findFirst();
        Integer op11 = list8.stream().sorted((a,b) -> b.compareTo(a)).skip(1).findFirst().orElse(0);
        System.out.println(op10.get() +"  "+ op11);


    }
}