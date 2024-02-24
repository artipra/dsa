package stream.demoproject;

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

//        List<List<Project>> list1 = Arrays.asList(employeeList.get(0).getProjects(),employeeList.get(1).getProjects(),employeeList.get(2).getProjects());
//        list1.stream().flatMap(List::stream).forEach(
//                s -> {
//                    System.out.println("project(name="+s.getName()+", team="+s.getTeam() +", projectManager="+s.getProjectManager()+")");
//                });
        //List all distinct project in non-ascending order.
        Comparator byName = Comparator.comparing(Project::getName);
                 employeeList
                .stream().map(e -> e.getProjects())
                .flatMap(List::stream)
                .distinct()
                .sorted((a,b) -> -a.getName().compareTo(b.getName()))
                .forEach(System.out::println);
        employeeList.stream().map(e -> e.getProjects()).flatMap(List::stream).distinct().sorted(byName.reversed()).forEach(System.out::println);

//        Print full name of any employee whose firstName starts with ‘A’.
         employeeList.stream().filter(s -> s.getFirstName().startsWith("A"))
                 .forEach(name -> System.out.println(name.getFirstName() +" "+ name.getLastName()));

//        List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)

        System.out.println("Q3");
        employeeList
                .stream()
                .filter(emp -> emp.getId().substring(0,4).equals("2023"))
                .forEach(System.out::println);

        System.out.println("Q4");
        Comparator<Employee> name = Comparator.comparing(Employee::getFirstName);
        Comparator<Employee> salary = Comparator.comparing(Employee::getSalary);
        employeeList.stream().sorted(name.thenComparing(salary)).forEach(System.out::println);

        System.out.println("q5");
        employeeList.stream().sorted(salary).forEach(System.out::println);
        Optional<Employee> thirdSalary = employeeList.stream().sorted(salary.reversed()).skip(2).findFirst();
        List<Employee> thirdHighestSalary = employeeList.stream().filter( e -> e.getSalary() == thirdSalary.get().getSalary()).collect(Collectors.toList());
        System.out.println(thirdHighestSalary);

        Map.Entry<Integer,List<Employee>> map =
                 employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getSalary,Collectors.toList()))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList()).get(2);
            System.out.println(map.getValue());

        System.out.println("Q6");
        OptionalInt op2 = employeeList.stream().mapToInt(Employee::getSalary).min();
        System.out.println(op2.getAsInt());
        System.out.println("q7");


        List<Employee> minSalaryEmployees =
                employeeList
                        .stream()
                        .collect(Collectors.groupingBy(Employee::getSalary,TreeMap::new,Collectors.toList())).firstEntry().getValue();

        System.out.println(minSalaryEmployees);
        System.out.println("q8");
        List<Employee> workinmorethan2projects =
                 employeeList
                .stream()
                .filter(e -> e.getProjects().size() > 2)
                .collect(Collectors.toList());
        System.out.println(workinmorethan2projects);

        System.out.println("Q9");
        long count = employeeList.stream().mapToInt(Employee::getTotalLaptopsAssigned).sum();
        System.out.println(count);

        System.out.println("Q10");

        long projectCount =
                employeeList
                .stream()
                .flatMap(pm ->pm.getProjects().stream()).filter(p -> "Robert Downey Jr".equalsIgnoreCase(p.getProjectManager())).distinct().count();
        System.out.println(projectCount);

        System.out.println("Q11");
        List<String> projectWithPM =
                employeeList
                        .stream()
                        .flatMap(pm ->pm.getProjects().stream()).filter(p -> "Robert Downey Jr".equalsIgnoreCase(p.getProjectManager()))
                        .distinct().map(project -> project.getName())
                        .collect(Collectors.toList());
        System.out.println(projectWithPM);
//        12. List of all people working with Robert Downey Jr.
        System.out.println("Q12");
        String pm = "Robert Downey Jr";

employeeList.stream().filter(
    each -> each.getProjects().stream().anyMatch(eachP -> pm.equalsIgnoreCase(eachP.getProjectManager())))
    .forEach(System.out::println);

//  13. Create a map based on this data, they key should be the year of joining, and value should be
//        list of all the employees who joined the particular year.

        Map<String, List<Employee>> employeeMapWithYear =
                employeeList.stream().collect(Collectors.groupingBy(e -> e.getId().substring(0,4)));

        System.out.println(employeeMapWithYear);
        System.out.println("q14");
        Map<String, Long> employeeMapWithYearCount =
                employeeList.stream().collect(Collectors.groupingBy(e -> e.getId().substring(0,4),Collectors.counting()));

        System.out.println(employeeMapWithYearCount);

    }
}
