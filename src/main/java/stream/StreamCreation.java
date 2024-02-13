package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.DoubleToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
//creation of stream
//stream.Of()
//Collection.stream()
//Arrays.stream()
//primitive Type stream -IntStream.Of(), LongStream.Of(),DoubleStreamof()
// File stream
//stream() is default method in Collection interface, so inherited by all classes which implements Collection interface
//Map is not collection, If you want stream of map you must first use entrySet() to trun Map into set
// primitive stream design to avoid autoboxing DoubleStream,IntStream and LongStream
// lines() static method of Files return a stream, it returns one line at a time
//stream.empty() -- to create empty stream
public class StreamCreation {


    public static void main(String[] args) {
     //stream.Of()
     Stream<String> streamStringOf = Stream.of("abc","cdf","ghi");
     Optional<String> optionalString = streamStringOf.findFirst();
        System.out.println(optionalString);
     //Collection.stream()
        //List
       List<Double> listStream = Arrays.asList(102.3,105.03,100.66);
       long cnt = listStream
       .stream()
       .filter(a -> a > 101)
       .count();
        System.out.println(cnt);
        //Set
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);treeSet.add(9);treeSet.add(10);
        Stream<Integer> setStream = treeSet.stream();
        System.out.println(setStream.filter(a -> a>1).count());
        //Map
        Map<String,Integer> map = new HashMap();
        map.put("a",1);map.put("b",2);map.put("c",3);
        map.put("d",4);map.put("e",5);map.put("f",6);
        System.out.println(map.entrySet().stream().filter(d -> d.getKey()=="b").findAny());
       //Arrays.stream()
        String[] str = {"abc","def"};
        Stream<String> streamArray = Arrays.stream(str);
        Optional<String> strOptional = streamArray.findFirst();
        System.out.println(strOptional);
        int[] intArr = {1,2,5,8};
        //Stream<Integer> streamIntArr = Arrays.stream(intArr);// retrun IntStream
        //primitive Type stream
        // can seen that no type is mentioned
        DoubleStream doubleStream = DoubleStream.of(102.22,104.22,103.00,104.00);
        System.out.println(doubleStream.count());
      // File stream
        String filePath = "C:\\Users\\Arti\\IdeaProjects\\dsa\\src\\main\\java\\resource\\dvdinfo.txt";
        List<DVDInfo> dvds = loadDVD(filePath);
        dvds.stream().forEach(System.out::println);
        Long fileCount = fileCount(filePath);
        System.out.println(fileCount);

    }

    public static long fileCount(String fileName){
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get(fileName));
        }
        catch(IOException e){
            System.out.println("error in reading");
            e.printStackTrace();
        }
        return stream.count();
    }

    public static List<DVDInfo> loadDVD(String fileName){
        List<DVDInfo> dvds = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            stream.forEach(line -> {
                String[] dvdItems = line.split("/");
                DVDInfo dvd = new DVDInfo(dvdItems[0],dvdItems[1],dvdItems[2]);
               dvds.add(dvd);
            });
        }catch(IOException e){
            System.out.println("error in reading");
            e.printStackTrace();
        }
        return dvds;
    }

}
