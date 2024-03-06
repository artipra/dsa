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

        //List all distinct projects in non-ascending order.
        Comparator byName = Comparator.comparing(Project::getName);
                 employeeList
                .stream()
                 .map(e -> e.getProjects())
                .flatMap(List::stream)
                .distinct()
                .sorted((a,b) -> -a.getName().compareTo(b.getName()))
                .forEach(System.out::println);
        Object list1 = employeeList
                .stream()
                .map(e -> e.getProjects())
                .flatMap(List::stream)
                .distinct()
                .sorted(byName.reversed())
                .collect(Collectors.toList());
        System.out.println();
        System.out.println(list1);

//        Print full name of any employee whose firstName starts with ‘A’.
        employeeList.stream().filter(e ->e.getFirstName().startsWith("A"))
                .forEach( s -> System.out.println(s.getFirstName()+" "+s.getLastName()));


//      List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
        List<Employee> emp1 = employeeList.stream().filter(s -> s.getId().substring(0,4).equals("2023")).collect(Collectors.toList());
        System.out.println(emp1);

//        4. Sort employees based on firstName, for same firstName sort by salary.
        Comparator<Employee> firstNameThenSalary = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary);
        List<Employee> res3 = employeeList.stream().sorted(firstNameThenSalary).collect(Collectors.toList());
        System.out.println(res3);

//       5 Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
        Map.Entry<Integer,List<Employee>> res4 = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList()).get(2);
        System.out.println(res4);
        System.out.println();

//     7. Print list of all employees with min salary.
       List<Employee> minSalarys = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary,TreeMap::new,Collectors.toList()))
               .firstEntry().getValue();
        System.out.println(minSalarys);
        System.out.println("Q8");
//     8. List of people working on more than 2 projects.
        List<Employee> res5 = employeeList.stream().filter(e -> e.getProjects().size() > 2).collect(Collectors.toList());
        System.out.println(res5);

//     10. Count of all projects with Robert Downey Jr as PM.
        System.out.println("Q10");
        long res6 = employeeList.stream().map(Employee::getProjects).flatMap(List::stream).filter(p -> p.getProjectManager().equals("Robert Downey Jr")).distinct().count();
        System.out.println(res6);
        System.out.println("Q11");
//        11. List of all projects with Robert Downey Jr as PM.
        List<Project> res7= employeeList.stream().map(Employee::getProjects).flatMap(List::stream).filter(p -> p.getProjectManager().equals("Robert Downey Jr")).distinct().collect(Collectors.toList());
        System.out.println(res7);
        System.out.println("Q13");
//        13. Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.
        Map<String,List<Employee>> res8 = employeeList.stream().collect(Collectors.groupingBy(e -> e.getId().substring(0,4)));
        System.out.println(res8);


        System.out.println("Q14");
//     14 Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.
        Map<String,Long> res9 = employeeList.stream().collect(Collectors.groupingBy(e -> e.getId().substring(0,4),Collectors.counting()));
        System.out.println(res9);

        ArrayList<Number> list = new ArrayList<>();
        list.add(1);
        list.add(1L);
    }


}
