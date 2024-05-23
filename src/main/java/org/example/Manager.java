package org.example;

import java.math.BigDecimal;

public class Manager extends Employee{

    private int teamSize;

    public Manager(String name, int age, BigDecimal salary, int teamSize) {
        super(name, age, salary);
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return "Vardas: " + getName() + ", Amzius: " + getAge() + ", Alga: " + getSalary() + "Komandos dydis: " + getTeamSize();

    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    void work() {

    }
}
