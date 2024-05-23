package org.example;

import java.util.List;

public interface EmployeeService {
    void performDuties(Employee e);
    String getEmployeeInfo(Employee e);
    void promoteEmployee(Employee e);
    void changeName(Employee e, String name);
    void changeAge(Employee e, int age);
    void fireEmployee(Employee e);
    double calculateBonus(Employee e);
    void evaluatePerformance(Employee e, int performanceScore);
    void transferDepartment(Employee e, String newDepartment);
    void listAllEmployees(List<Employee> employees);
    Employee findEmployeeByName(List<Employee> employees, String name);
}
