package stream;

//map-filter-reduce
// map - map transforms elements of a stream, map() takes a Function
// and Function's apply method takes one value and produces another value
//filter - filter stream
//reduce - reduce() is both general method as well specific method,are terminal operation
// basic reduce() method takes BiFunctional
// peek() method takes consumer and allows you to peek into a stream as data is flowing
//mapToDouble() takes ToDoubleFunction, whose applyAsDouble() method takes object and returns a double
// average(),min()max() are meant to use with number therefore will not find in stream interface, define in primitive stream
//average()min() and max() return optional but sum() not because sum of empty stream can be 0
//average() return OptionalDouble which represents values that may or may not present
//Optional can be null so its better to check value before using
//UnaryOperators, their function takes one argument and return same value
//BinaryOperators, their function takes two arguments and return same value
//Operators are special type of function in that argument and return value of function must be same.
// reduce() method returns optionalDouble as its general method and there can be chance that call on empty stream so in that case
// error can arise
//there's another form of reduce() method
//double reduce(double identity,DoubleBinaryOperator op) ... its return double as identity can be used as initial value if stream is not empty
// and identity provides a default result if stream is empty
//page no 570,572,552,576,586,587

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class OperatingOnStream {
    public static void main(String[] args) {
     // takes list of integer,if square is > 20 then count
        List<Integer> list = Arrays.asList(1,5,3,8,6);
        long count = list.stream().map(d -> d*d).filter(d -> d>20).count();
        System.out.println(count);
        // In this steam cant print number and its square but workaround
        // is peek() method takes consumer and allows you to peek into a stream as data is flowing
        long countPeek =
                list
                        .stream()
                        .peek(n -> System.out.println("The number is "+n+","))
                        .map(d -> d*d)
                        .filter(d -> d>20)
                        .peek(n -> System.out.println("square is "+n)).count();

        System.out.println(countPeek);

        //Map-Filter-Reduce with average and optionals
        List<Reading> readingList = Arrays.asList(
                new Reading(2017,1,1,405.91),
                new Reading(2017,1,8,405.98),
                new Reading(2017,1,15,406.14),
                new Reading(2017,1,22,406.48),
                new Reading(2017,1,29,406.20),
                new Reading(2017,2,5,407.12),
                new Reading(2017,2,12,406.03));

        OptionalDouble avg = readingList
                .stream()
                .mapToDouble(d -> d.value)
                .filter(v -> v >= 406 && v <= 407)
                .average();

        System.out.println(avg);
        System.out.println(avg.getAsDouble());

     //create your reduction method using reduce() method
        OptionalDouble reduceOptional = readingList
                .stream()
                .mapToDouble(d -> d.value)
                .filter(v -> v >= 406 && v <= 407)
                .reduce((v1,v2) -> v1+v2);
        System.out.println(reduceOptional);

        //reduce and Associative Accumulations
        //reduction operation must be associative in order to work correctly with stream

    }

}
