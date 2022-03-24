package com.employee;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {

    static ArrayList<Employee> empList = new ArrayList<>();


    public static <E> Employee searching(E value) {

        for (Employee em : empList) {
            if ((em.getCompanyName()).equals(value)) {
                return em;
            } else if ((em.getName()).equals(value)) {
                return em;
            } else if ((em.getDept()).equals(value)) {
                return em;
            } else if ((em.getId() + "").equals(value)) {
                return em;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        empList.listIterator();

        Employee emp1 = new Employee();
        emp1.setId("1");
        emp1.setCompanyName("HCL");
        emp1.setName("anas");
        emp1.setSalary(600000);
        emp1.setDept("SOFTWARE");
        emp1.setMobNo(98181818);
        Address add1 = new Address();
        emp1.setAddress(add1);
        add1.setPincode(110027);
        add1.setCity("New delhi");
        add1.setCountry("india");
        add1.setState("delhi");
        add1.setDistric("south east");

        Employee emp2 = new Employee();
        emp2.setId("1");
        emp2.setCompanyName("InsightGeeks");
        emp2.setName("anas");
        emp2.setSalary(60000);
        emp2.setDept("developer");
        emp2.setMobNo(981818181);
        Address add2 = new Address();
        emp2.setAddress(add2);
        add2.setPincode(110025);
        add2.setCity("New delhi");
        add2.setCountry("india");
        add2.setState("delhi");
        add2.setDistric("south east");

        Employee emp3 = new Employee();
        emp3.setId("2");
        emp3.setCompanyName("HCL");
        emp3.setName("anas");
        emp3.setSalary(60000);
        emp3.setDept("developer");
        emp3.setMobNo(981818181);
        Address add3 = new Address();
        emp3.setAddress(add3);
        add3.setPincode(110025);
        add3.setCity("New delhi");
        add3.setCountry("india");
        add3.setState("delhi");
        add3.setDistric("south east");

        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);

//        //searching by id, name, dept, company
//        for (Employee em : empList) {
//            System.out.println(searching(em.getId()).toString());
//            System.out.println(searching(em.getCompanyName()).toString());
//
//        }

        //filter by id remove duplicates
//        Iterator it = filteringById().iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next().toString());
//        }


        //Average Salary by company wise
        // Set<Map.Entry<String, Double>>entry = averageSalary().entrySet();

        for (Map.Entry<String, Double> entry : averageSalary().entrySet()) {
            System.out.println("key " + entry.getKey() + " value " + entry.getValue());
        }


    }

    public static Set filteringById() {
        HashSet<Employee> set = new HashSet<>();
        for (Employee em : empList) {
            set.add(searching(em.getId()));
        }
        return set;
    }

    public static Map<String, Double> averageSalary() {


        //here groupby is used for finding the average salary of all employee company wise
       // Map<String, Double> collect = empList.stream().collect(Collectors.groupingBy(Employee::getCompanyName, Collectors.averagingDouble(Employee::getSalary)));

        //another approach
        Map<String, Double> collect = empList.stream().collect(Collectors.toMap(Employee::getCompanyName, Employee::getSalary,(exi,neww)->(exi+neww)/2));

        //using flat map
        Map<String, Double> collect1 = empList.stream().collect(Collectors.toMap(Employee::getCompanyName, Employee::getSalary,(exi,neww)->(exi+neww)/2));

        //store our data in a linked HashMap using Supplier
        LinkedHashMap<String, Double> linkedHashMap = empList.stream().collect(Collectors.toMap(Employee::getCompanyName, Employee::getSalary,(exi,neww)->(exi+neww)/2,LinkedHashMap::new));
        System.out.println("hello print value  " + collect);


//        //approach 2 Using Reduce method
//        Double reduce = empList.stream().reduce(0.0, (res, emp) -> (res + emp.getSalary()) / 2);
//        System.out.println("Using reduce "+reduce);
//

//
        //comparing by employee name idf t=nae are same then compare by id
//        Comparator<Employee> lis = Comparator.comparing(Employee::getName).thenComparing(Employee::getId);
//        List<Employee> sortedLIst = empList.stream().sorted(lis).collect(Collectors.toList());
//        System.out.println("sorted list");
//        System.out.println(sortedLIst);

//        double asDouble = empList.stream().filter(em -> listOfEmployee.contains(em.getCompanyName())).mapToDouble(emp1 -> emp1.getSalary()).average().getAsDouble();
//        BiPredicate<String,Employee> pre = (c,e)->e.getCompanyName().equalsIgnoreCase(c);

        return collect;
    }
}
