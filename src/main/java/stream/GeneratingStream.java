package stream;

import java.util.stream.Stream;

//Stream.iterate() returns infinite sequential order stream
//iterate() method takes unaryOpeartion
//generate() is generate infinite stream
//range(),rangeClosed generates primitive stream
//limit(),skip()
public class GeneratingStream {

    public static void main(String[] args) {

        //nothing is kick off as stream are lazy
        Stream.iterate(0, s-> s+1);
        //infinte loop will run
        //Stream.iterate(0, s-> s+1).forEach(System.out::println);
      //  int i=0;
          Stream.generate(() -> 1).forEach(System.out::println);
    }
}
