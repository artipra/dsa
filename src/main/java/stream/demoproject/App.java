package stream.demoproject;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        List<Employee> employeeList = employeeFactory.getAllEmployee();


        employeeList.stream()
                    .map(e -> e.getProjects())
                    .flatMap(List::stream)
                    .sorted((o1,o2) -> o2.getName().compareTo(o1.getName())).distinct()
                    .forEach(System.out::println);


        employeeList.stream()
                .filter(s -> s.getFirstName().startsWith("A"))
                .forEach( e -> System.out.println(e.getFirstName()+","+e.getLastName()));

       List<Employee> joinedIn2023 =  employeeList.stream()
                .filter(s -> s.getId().substring(0,4).equals("2023"))
                .collect(Collectors.toList());

        System.out.println(joinedIn2023);

        Comparator<Employee> firstName = Comparator.comparing(Employee::getFirstName);
        Comparator<Employee> salary = Comparator.comparing(Employee::getSalary);
        List<Employee> sortedEmp = employeeList.stream().sorted(firstName.thenComparing(salary)).collect(Collectors.toList());
        System.out.println(sortedEmp);

        Map.Entry<Integer,List<Employee>> maplist = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary))
                        .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(2);
        System.out.println(maplist);

           List<Employee> empList = employeeList.stream().sorted((a,b) -> a.getSalary() - b.getSalary())
                   .collect(Collectors.groupingBy(Employee::getSalary,TreeMap::new,Collectors.toList())).firstEntry().getValue();
        System.out.println(empList);

        employeeList.stream().filter(e -> e.getProjects().size()>2).forEach(System.out::println);
    }


}
