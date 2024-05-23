package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class EmployeeServiceUI {
    public void menu(){
        Scanner sk = new Scanner(System.in);
        boolean flag = true;
        EmployeeServiceImpl eImpl = new EmployeeServiceImpl();
        Employee manager1 = new Manager("Rokas", 40, BigDecimal.valueOf(2250.00), 15);
        eImpl.darbuotojuSarasas();
        while(true){
            System.out.println("1 - performDuties\n" +
                    "2 - getEmployeeInfo\n" +
                    "3 - promoteEmployee\n" +
                    "4 - changeName\n" +
                    "5 - changeAge\n" +
                    "6 - fireEmployee\n" +
                    "7 - calculateBonus\n" +
                    "8 - evaluatePerformance\n" +
                    "9 - transferDepartment\n" +
                    "10 - listAllEmployees\n" +
                    "11 - findEmployeeByName\n" +
                    "12 - baigti");
            int pasirinkimas = sk.nextInt();
            sk.nextLine();
            switch (pasirinkimas){
                case 1:
                    eImpl.performDuties(manager1);
                    break;
                case 2:
                    eImpl.getEmployeeInfo(manager1);
                    break;
                case 3:
                    eImpl.promoteEmployee(manager1);
                    break;
                case 4:
                    eImpl.changeName(manager1, "Viktoras");
                    break;
                case 5:
                    eImpl.changeAge(manager1, 52);
                    break;
                case 6:
                    eImpl.fireEmployee(manager1);
                    break;
                case 7:
                    eImpl.calculateBonus(manager1);
                    break;
                case 8:
                    eImpl.evaluatePerformance(manager1, 9);
                    break;
                case 9:
                    eImpl.transferDepartment(manager1, "Vadyba");
                    break;
                case 10:
                    eImpl.listAllEmployees(eImpl.darbuotojuSarasas);
                    break;
                case 11:
                    eImpl.findEmployeeByName(eImpl.darbuotojuSarasas, "Mantas");
                    break;
                case 12:
                    System.exit(0);
            }



        }

    }
}
