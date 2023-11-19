package stream;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalDemo {

    public static void main(String[] args) {
        Stream<Double> streamDouble = Stream.of(1.0, 2.0, 3.0, 8.3, 9.6);
        Optional<Double> val = streamDouble.findAny();
        if (val.isPresent()) {
            System.out.println(val.get());
        } else {
            System.out.println("optional is empty");
        }

        val.ifPresent(n -> System.out.println("val is "+n));

        //create your own optional
        Reading read = new Reading(2014,2,22,10.0);
        Optional<Reading> reading = Optional.of(read);
        reading.ifPresent(System.out::println);

        //if optional null ifPresent() will give NPE
//        Optional<Reading> readingNull = Optional.of(null);
        Optional<Reading> readingNull = Optional.ofNullable(null);
        readingNull.ifPresent(System.out::println);

        //other way to handle empty/null optional orElse,
        // if optional empty you get value specified in orElse
        Optional<Reading> readingOrElse = Optional.ofNullable(null);
        Reading orElse = readingOrElse.orElse(read);
        System.out.println(orElse);

    }

}
