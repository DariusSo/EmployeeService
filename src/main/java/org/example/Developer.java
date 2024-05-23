package org.example;

import java.math.BigDecimal;

public class Developer extends Employee{

    private Enum programmingLanguage;

    public Developer(String name, int age, BigDecimal salary, Enum programmingLanguage) {
        super(name, age, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public Enum getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(Enum programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void work() {

    }

    @Override
    public String toString() {
        return "Vardas: " + getName() + ", Amzius: " + getAge() + ", Alga: " + getSalary() + ", Programavimo kalba: " + getProgrammingLanguage();
    }
}
