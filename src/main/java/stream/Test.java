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

        List<String> list = Arrays.asList("a","B","c","D");
        List<String> upperCase = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(upperCase);
        List<String> lowerCase = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowerCase);

        List<Integer> list1 = Arrays.asList(1,2,3,5,9,4);
        double evenSum = list1.stream().filter(i -> i%2==0).mapToInt(i->i).sum();
        double oddSum = list1.stream().filter(i -> i%2!=0).mapToDouble(Integer::doubleValue).sum();
        System.out.println(evenSum +" "+oddSum);

        List<Integer> list2 = Arrays.asList(1,2,3,5,1,2,4,9,4);
        List<Integer> uniList = list2.stream().distinct().collect(Collectors.toList());
        Set<Integer> unilist2 = list2.stream().collect(Collectors.toSet());
        System.out.println(uniList);
        System.out.println(unilist2);

        List<String> list3 = Arrays.asList("ab","fbv","abc","arf","rgh");
        List<String> listA = list3.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        System.out.println(listA);

        List<String> list4 = Arrays.asList("ab","fbv","abc","rf","gfh");
        List<String> sort1 = list4.stream().sorted().collect(Collectors.toList());
        List<String> sort2 = list4.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sort1);
        Comparator<String> reverseComp = Comparator.comparing(String::toString).reversed();
        List<String> sort3 = list4.stream().sorted(reverseComp).collect(Collectors.toList());
        System.out.println(sort3);

        List<Integer> list5 = Arrays.asList(1,2,3,4,7,9,55,8);
// 7. Write a Java program to find the maximum and minimum values in a list of integers using streams.
        OptionalInt maxInt = list5.stream().mapToInt(Integer::intValue).max();
        OptionalInt minInt  = list5.stream().mapToInt(Integer::intValue).min();
        System.out.println(maxInt.getAsInt());
        System.out.println(minInt.getAsInt());

        Optional<Integer> max1 = list5.stream().collect(Collectors.maxBy((o1,o2) -> o1.intValue() - o2.intValue()));
        System.out.println(max1);

        Optional<Integer> min1 = list5.stream().sorted().limit(1).findFirst();
        System.out.println(min1);

        Optional<Integer> max2 = list5.stream().sorted((o1,o2) -> o2.intValue() - o1.intValue()).limit(1).findFirst();
        System.out.println(max2);


        List<Integer> list6 = Arrays.asList(2,6,11,15);
        Optional<Integer> secondSmallest = list6.stream().sorted().skip(1).findFirst();
        System.out.println(secondSmallest);
        Optional<Integer> secondLargest = list6.stream().sorted((a,b) -> b.compareTo(a)).skip(1).findFirst();
        System.out.println(secondLargest);


    }

}