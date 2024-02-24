package stream;
//flatMap() it flattens out the streams

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOfStream {

    public static void main(String[] args) {


        String str = "abc,adf,java,jff,java,pol,java,than,java";
        Stream<String[]> inputStream = Stream.of(str).map(line -> line.split(","));

        List javaCnt = inputStream
                .flatMap(array -> Arrays.stream(array))
                .filter(s -> s.indexOf("java")>-1).collect(Collectors.toList());

        System.out.println(javaCnt);


    }
}
