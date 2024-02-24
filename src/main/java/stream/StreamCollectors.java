package stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//collect() method is reduction method, reduces s stream into a collection of objects or a value
// Collector you pass in stream tells how to reduce stream
//Collectors class provide implementation of collector that each determine you collect
//collect(Collectors.toList()); there's no guarantee what type of list coming,
// so specific you want then try like this collect(Collectors.toCollection(LinkedList::new))
// Collectors.toCollection(Supplier) takes supplier and return a new empty collection
//Collectors.groupingBy() takes function(based on group by is done, and its key in map) and return collector, nas based on return collector value is mapped into map
//groupingBy() is heavily overloaded so do check out
//partioningBy() takes predicate based on predicate split result in 2 parts
//averagingInt() and summingInt() are also called downstream processing as they work on first reduction operation's results
//joiningBy() takes input which implement CharSequence interface
//minBy()maxBy() takes comparator and return Optional<T>

public class StreamCollectors {

    public static void main(String[] args) {

        List<Person> listPerson = getPersonList();
        List<Person> peopleAge34 = listPerson
                                   .stream()
                .filter( a -> a.getAge() == 34)
                .collect(Collectors.toList());

        System.out.println("people age 34 "+peopleAge34);// there's no guarantee what type os list coming, so specific you want then try like this

        List<Person> peopleAge34ArrayList = listPerson
                .stream()
                .filter( a -> a.getAge() == 34)
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("people age 34 "+peopleAge34ArrayList);

//        String path = "C:\\Users\\Arti\\IdeaProjects\\dsa\\src\\main\\java\\resource\\dvdinfo.txt";
//        List<DVDInfo> dvds = loadDvdCollect(path);
//        System.out.println(dvds);


        //Collectors.groupingBy()
        Map<Integer,List<Person>> peopleGroup =
                listPerson
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println("grouping by "+peopleGroup);

        //Collectors.groupingBy(function,collector) // take Function as classification and collector is which resilt is to be collected
        Map<Integer,Long> peopleGroup1 =
                listPerson
                        .stream()
                        .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println();
        System.out.println("grouping by overloaded "+peopleGroup1);

        //Collectors.groupingBy(function,collector) // take Function as classification and collector is which result is to be collected
        //mapping() takes a function, whose functional method takes an object we r mapping from and return another object
        //second argument tell what to with multiple values
        Map<Integer,List<String>> peopleGroup2 =
                listPerson
                        .stream()
                        .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName,Collectors.toList())));
        System.out.println();
        System.out.println("grouping by overloaded 2"+peopleGroup2);
    //partioningBy()
        Map<Boolean,List<Person>> partitionBy =
                listPerson
                        .stream()
                        .collect(Collectors.partitioningBy(d ->d.getAge() > 34));
        System.out.println();
        System.out.println("partitioning by "+partitionBy);


        //summingInt()
        Map<String,Integer> summningInt =
                         listPerson
                        .stream()
                         .filter( p -> p.getName().startsWith("B"))
                        .collect(Collectors.groupingBy(Person::getName , Collectors.summingInt(Person::getAge)));
        System.out.println();
        System.out.println("summingInt() "+summningInt);

        //averagingInt()
        Map<String,Double> averagingInt =
                listPerson
                        .stream()
                        .filter( p -> p.getName().startsWith("B"))
                        .collect(Collectors.groupingBy(Person::getName , Collectors.averagingInt(Person::getAge)));
        System.out.println();
        System.out.println("averagingInt() "+averagingInt);

        //Collectors.joining()
        String JoiningBy =
                listPerson
                        .stream()
                        .filter( p -> p.getName().startsWith("B"))
                        .map(Person::getName)
                        .collect(Collectors.joining(","));
        System.out.println();
        System.out.println("joining() "+JoiningBy);

    }


    static List<Person> getPersonList(){
        Person beth = new Person("Beth",30);
        Person eric = new Person("eric",31);
        Person deb = new Person("deb",31);
        Person liz = new Person("Liz",30);
        Person wendi = new Person("Wendi",34);
        Person kathy = new Person("Kathy",35);
        Person bert = new Person("Bert",32);
        Person bill = new Person("Bill",34);
        Person robert = new Person("Robert",38);

        List<Person> people = new ArrayList<Person>();
        people.add(beth);people.add(eric);people.add(deb);
        people.add(liz);people.add(wendi);people.add(kathy);
        people.add(bert);people.add(bill);people.add(robert);

        return people;
    }


    public static List<DVDInfo> loadDvdCollect(String fileName){
       List<DVDInfo> dvds = null;
       try(Stream<String> stream = Files.lines(Paths.get(fileName))){
//                 stream
//                 .map(line -> new String[])
//                 .map(d -> new DVDInfo(d[0],d[1],d[2]))
//                 .collect(Collectors.toCollection(() - > DVDInfo::new))
           dvds = stream
                   .map(lines -> {
                       String[] line = lines.split("/");
                       return new DVDInfo(line[0], line[1], line[2]);
                   })
                   .collect(Collectors.toCollection(() -> new ArrayList<DVDInfo>()));
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return dvds;
    }

}
