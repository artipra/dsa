package stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.averagingInt;

class Test{

    public static void main(String [] args){

        List<Integer> list = Arrays.asList();
        Double op = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println(op);


        List<String> list1 = Arrays.asList("ab","BM","Mb");
        List<String> upper = list1.stream().map(String ::toUpperCase).collect(Collectors.toList());
        List<String> lower = list1.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(upper);
        System.out.println(lower);

        List<Integer> list3 = Arrays.asList(1,2,3);
        int even = list3.stream().filter(i -> i%2 == 0).mapToInt(Integer::intValue).sum();
        double odd = list3.stream().filter(i -> i%2 != 0).mapToDouble(Integer::doubleValue).sum();
        System.out.println("even "+even +" odd "+odd);


        List<Integer> list4 = Arrays.asList(1,2,5,2,2);
        List<Integer> unique = list4.stream().distinct().collect(Collectors.toList());
        Set<Integer> unique1 = list4.stream().collect(Collectors.toSet());
        System.out.println(unique);
        System.out.println(unique1);


        List<String> list5 = Arrays.asList("abc","mn","ab","aaa","Arti");
        List<String> uniqueList = list5.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        System.out.println(uniqueList);


        List<String> list6 = Arrays.asList("abc","mn","tb","aaa","arti");
        Comparator<String> byName = Comparator.comparing(String::toString);
        List<String> sortList1 = list6.stream().sorted(byName).collect(Collectors.toList());

//        List<String> sortList2 = list6.stream().sorted((a,b) -> -a.compareTo(b)).collect(Collectors.toList());
        List<String> sortList3 = list6.stream().sorted(byName.reversed()).collect(Collectors.toList());
        System.out.println(sortList1);
//        System.out.println(sortList2);
        System.out.println(sortList3);

        List<Integer> list7 = Arrays.asList(5,2,9,7,0,5);
        OptionalInt op1 = list7.stream().mapToInt(Integer::intValue).max();
        System.out.println(op1.getAsInt());
        OptionalInt op2 = list7.stream().mapToInt(Integer::intValue).min();
        System.out.println(op2.getAsInt());


        Optional<Integer> op3 = list7.stream().sorted().limit(1).findFirst();
        Optional<Integer> op4 = list7.stream().sorted((a,b) -> -a.compareTo(b)).limit(1).findFirst();
        System.out.println(op3.get());
        System.out.println(op4.get());

        Integer op5 = list7.stream().min(Integer::compare).orElse(0);
        System.out.println(op5);


        List<Integer> list8 = Arrays.asList(5,2,9,7,0,5);
        Optional<Integer> op6 = list8.stream().distinct().sorted().skip(1).findFirst();
        Optional<Integer> op7 = list8.stream().distinct().sorted((a,b) -> -a.compareTo(b)).skip(1).findFirst();
        System.out.println(op6.get());
        System.out.println(op7.get());
    }

}

@Getter
@AllArgsConstructor
@ToString
class Employee{
    private String name;
    private int age;
    private double salary;
    private String gender;


    Employee(String name,int age){
        this.name = name;
        this.age = age;
    }
}