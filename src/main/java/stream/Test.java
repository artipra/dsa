package stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.w3c.dom.ls.LSOutput;
import stream.demoproject.Employee;
import stream.demoproject.EmployeeFactory;
import stream.demoproject.Project;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.*;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.mapping;

class Test{

    public static void main(String [] args) {
        List<Integer> list = Arrays.asList(12,3,6,5,4,8);
        System.out.println(list.stream().mapToInt(Integer::intValue).average().orElse(0.0));
        System.out.println(list.stream().mapToInt(i -> i).average());
        System.out.println(list.stream().mapToDouble(Integer::doubleValue).average());
        System.out.println(list.stream().collect(Collectors.averagingInt(i -> i)));

        List<String> list1 = Arrays.asList("abc","bn","tt","gg");
        Stream<String> stream1 = list1.stream();
        System.out.println(stream1.map(String::toLowerCase).collect(Collectors.toList()));
        System.out.println(list1.stream().map(String::toUpperCase).collect(Collectors.toList()));

        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list2.stream().filter(i -> i%2 == 0).mapToInt(i ->i).sum());
        System.out.println(list2.stream().filter(i -> i%2 != 0).mapToInt(i ->i).sum());
        System.out.println(list2.stream().filter(i -> i%2==0).collect(Collectors.summingInt(i ->i)));

        List<Integer> list3 = Arrays.asList(1,2,3,4,2,3,1,5,6);
        System.out.println(list3.stream().distinct().collect(Collectors.toList()));

        List<String> list4 = Arrays.asList("ac","abc","po","ag","al","ai");
        System.out.println(list4.stream().filter(i -> i.startsWith("p")).count());

        List<String> list5 = Arrays.asList("ac","abc","po","ag","al","ai");
//        list5.stream().sorted().forEach(System.out::println);
//        list5.stream().sorted((a,b) -> b.compareTo(a)).forEach(System.out::println);
        list5.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Integer> list6 = Arrays.asList(1,5,88,9);
//        System.out.println(list6.stream().mapToInt(Integer::intValue).min().orElse(Integer.MIN_VALUE));
        System.out.println(list6.stream().collect(Collectors.minBy(Comparator.comparing(Integer::intValue))));
        System.out.println(list6.stream().collect(Collectors.minBy(Comparator.comparing(Integer::intValue).reversed())));

        List<Integer> list7 = Arrays.asList(1,5,88,9);
        System.out.println(list7.stream().sorted().skip(1).findFirst());

        System.out.println(list7.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());


        List<Employee> listEmp = EmployeeFactory.getAllEmployee();
        Stream<List<Project>> listProjects = listEmp.stream().map(Employee::getProjects);
        Stream<Project> projects = listProjects.flatMap(List::stream);
        System.out.println(projects.map(Project::getName).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        System.out.println("---------------------------------");
        listEmp = EmployeeFactory.getAllEmployee();
        listEmp.stream().filter(s -> s.getFirstName().startsWith("A")).forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getLastName()));

        listEmp = EmployeeFactory.getAllEmployee();
        listEmp.stream().filter(e -> e.getId().substring(0,4).equals("2023")).forEach(System.out::println);

        listEmp = EmployeeFactory.getAllEmployee();
        Comparator<Employee> c2 = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary);
        listEmp.stream().sorted(c2).forEach(System.out::println);

        for(Map.Entry<Integer,List<Employee>> entry : listEmp.stream().collect(Collectors.groupingBy(Employee::getSalary)).entrySet() ){
            System.out.println(entry);
        }


        listEmp = EmployeeFactory.getAllEmployee();
        Map.Entry<Integer,List<Employee>> thirdHighestSalary = listEmp.stream().collect(Collectors.groupingBy(Employee::getSalary)).entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(2);
        System.out.println(thirdHighestSalary);

        listEmp = EmployeeFactory.getAllEmployee();
        System.out.println(listEmp.stream().mapToInt(Employee::getSalary).min());


        listEmp = EmployeeFactory.getAllEmployee();
        Map.Entry<Integer,List<Employee>> minSalaryEmployees = listEmp.stream().collect(Collectors.groupingBy(Employee::getSalary)).entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()).get(0);
        System.out.println(minSalaryEmployees);

        listEmp = EmployeeFactory.getAllEmployee();
       List<Employee> peopleWorkingMorethanTwoProjects = listEmp.stream().filter(e -> e.getProjects().size()>2).collect(Collectors.toList());
        System.out.println(peopleWorkingMorethanTwoProjects);

        List<Employee> listEmp1 = EmployeeFactory.getAllEmployee();
//        Long ProjectsWithRobert = listEmp1.stream().map(Employee::getProjects).flatMap(List::stream).distinct().filter(p -> p.getProjectManager().equals("Robert Downey Jr")).count();
        System.out.println();

        List<Employee> listEmp3 = EmployeeFactory.getAllEmployee();
        Iterator<Employee> itr1 = listEmp3.iterator();
        List<Employee> res1 = new ArrayList<>();
        while(itr1.hasNext()){
        Employee e = itr1.next();
        List<Project> pro = e.getProjects();
        boolean flag = false;
        for(Project p : pro){
            if(p.getProjectManager().equalsIgnoreCase("Robert Downey Jr")){ flag = true; break;}
        }
            if(flag)res1.add(e);
        }
        System.out.println("===========================");
        System.out.println(res1.size());

        List<Employee> asPM = listEmp1.stream().filter(
                  e -> {
                      boolean flag = false;
                      for (Project project : e.getProjects()) {
                          if(project.getProjectManager().equalsIgnoreCase("Robert Downey Jr")){
                              flag = true;
                              break;
                          }
                      }
                      return flag;
                  }
                  ).collect(Collectors.toList());
        for(Employee p1 : asPM)
        System.out.println(p1);
    }

}