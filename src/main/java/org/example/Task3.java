package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        // Список сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ваня Иванов", 30, "HR", 50000.0));
        employees.add(new Employee("Петя Петров", 25, "IT", 70000.0));
        employees.add(new Employee("Дима Дмитриев", 40, "IT", 80000.0));
        employees.add(new Employee("Коля Николаев", 35, "HR", 60000.0));
        employees.add(new Employee("Миша Михайлов", 50, "Finance", 90000.0));

        printAverageSalaryByDepartment(employees, "IT");
    }

    public static void printAverageSalaryByDepartment(List<Employee> employees, String department) {
        double averageSalary = employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Средняя зарплата в департаменте " + department + ": " + averageSalary);
    }
}