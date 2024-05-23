package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    Scanner sk = new Scanner(System.in);
    List<Employee> darbuotojuSarasas = new ArrayList<>();

    @Override
    public void performDuties(Employee e) {
        if (e instanceof Manager) {
            if (((Manager) e).getTeamSize() > 10) {
                System.out.println("valdo didele komanda.");
            } else {
                System.out.println(e.getName() + " valdo maza komanda");
            }
        } else if (e instanceof Developer) {
            if(((Developer) e).getProgrammingLanguage().equals(ProgrammingLanguage.Csharp)){
                System.out.println("C# programuotojas, Alga: " + e.getSalary());
            } else if (((Developer) e).getProgrammingLanguage().equals(ProgrammingLanguage.JAVA)) {
                System.out.println("Java programuotojas, Alga: " + e.getSalary());
            }
            else{
                System.out.println("Reikia C++ programuotjo, Alga pagal susitarima");
            }
        }else{
            System.out.println("Reikia C++ programuotjo, Alga pagal susitarima");
        }
    }

    @Override
    public String getEmployeeInfo(Employee e) {
        return "Vardas: " + e.getName() + ", Amzius: " + e.getAge() + ", Alga: " + e.getSalary();
    }

    @Override
    public void promoteEmployee(Employee e) {
        if (e instanceof Manager){
            ((Manager) e).setTeamSize(((Manager) e).getTeamSize() + 1);
            if(((Manager) e).getTeamSize() > 15){
                e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.10)).setScale(2, RoundingMode.HALF_UP));
            }
        } else if (e instanceof Developer) {
            if(((Developer) e).getProgrammingLanguage().equals(ProgrammingLanguage.Csharp)){
                e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.07)).setScale(2, RoundingMode.HALF_UP));
            } else if (((Developer) e).getProgrammingLanguage().equals(ProgrammingLanguage.JAVA)) {
                e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12)).setScale(2, RoundingMode.HALF_UP));
            }
        }
    }

    public void darbuotojuSarasas(){
        Random r = new Random();
        Enum[] enumArray = new ProgrammingLanguage[]{ProgrammingLanguage.Csharp, ProgrammingLanguage.JAVA};

        BigDecimal managerSalary = new BigDecimal(2250.00);

        String[] names = {"Mantas", "Jonas", "Saulius", "Markas", "Tomas", "Domas", "Giedrius", "Paulius", "Erikas", "Lauris", "Lukas"};
        Employee manager = new Manager("Karolis", 36, managerSalary, names.length);
        darbuotojuSarasas.add(manager);
        for(int i = 0; i < names.length; i++){
            BigDecimal developerSalary = new BigDecimal(r.nextDouble(1500.00, 3000.00));
            BigDecimal developerSalaryRounded = developerSalary.setScale(2, RoundingMode.HALF_UP);

            Employee developer = new Developer(names[i], r.nextInt(20, 45), developerSalaryRounded,
                    enumArray[r.nextInt(0, enumArray.length)]);

            darbuotojuSarasas.add(developer);
        }
    }
    public void darbuotojai(){
        for (Employee e : darbuotojuSarasas){
            if(e instanceof Manager){
                if(((Manager) e).getTeamSize() > 10){
                    System.out.println(e.getName() + " valdo didele komanda.");
                }else{
                    System.out.println(e.getName() + " valdo maza komanda");
                }
            } else if (e instanceof Developer) {
                if(((Developer) e).getProgrammingLanguage().equals(ProgrammingLanguage.Csharp)){
                    System.out.println(e.getName() + " yra C# programuotojas, Alga: " + e.getSalary());
                } else if (((Developer) e).getProgrammingLanguage().equals(ProgrammingLanguage.JAVA)) {
                    System.out.println(e.getName() + " yra Java programuotojas, Alga: " + e.getSalary());
                }
                else{
                    System.out.println("Reikia C++ programuotjo, Alga pagal susitarima");
                }
            }else{
                System.out.println("Reikia C++ programuotjo, Alga pagal susitarima");
            }
        }
    }

    @Override
    public void changeName(Employee e, String name) {
        e.setName(name);
    }

    @Override
    public void changeAge(Employee e, int age) {
        e.setAge(age);
    }

    @Override
    public void fireEmployee(Employee e) {
        darbuotojuSarasas.remove(e);
    }

    @Override
    public double calculateBonus(Employee e) {
        if(e instanceof Manager){
            return Double.parseDouble(String.valueOf(e.getSalary())) * 0.10;
        } else if (e instanceof Developer) {
            return Double.parseDouble(String.valueOf(e.getSalary())) * 0.05;
        }else{
            return Double.parseDouble(String.valueOf(e.getSalary())) * 0.03;
        }
    }

    @Override
    public void evaluatePerformance(Employee e, int performanceScore) {
        if(performanceScore > 8){
            e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.10)));
        } else if (performanceScore > 6 && performanceScore < 9) {
            e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.05)));
        }else{
            System.out.println("Darbuotojo veikla yra nepatenkinama");
        }
    }

    @Override
    public void transferDepartment(Employee e, String newDepartment) {
        e.setDepartment(newDepartment);
    }

    @Override
    public void listAllEmployees(List<Employee> employees) {
        for(Employee e : employees){
            System.out.println(e);
        }
    }

    @Override
    public Employee findEmployeeByName(List<Employee> employees, String name) {
        for(Employee e : darbuotojuSarasas){
            if(Objects.equals(e.getName(), name)){
                return e;
            }
        }
        return null;
    }
}
