package com.ds.algos.practice.randomchallenge.hashtables.challenge;

import java.util.*;

// Remove duplicates from the original list. Prerequisites must use hashmap though not required!!!
public class HashtableChallengeTwo {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));

        HashMap<Integer, Employee> map = new HashMap<>();
        ListIterator<Employee> iterator = employees.listIterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if(!map.containsKey(employee.getId())) {
                map.put(employee.getId(), employee);
            } else {
                iterator.remove();
            }
        }

        map.forEach((id, employee) -> {
                    System.out.println("id: " + id + " first Name: "
                            + employee.getFirstName()
                            + " last Name: " + employee.getLastName());
                }
        );
        employees.forEach(e -> System.out.println(e));
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }
}