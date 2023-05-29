package com.classes.practice;

import com.mains.Employee;

import java.sql.SQLSyntaxErrorException;
import java.time.LocalDate;
import java.util.Objects;

/**
 * an implementation of the executive class which extends the Employee class
 * @author kamar baraka
 * @version 1.0
 * @since 27/05/2023*/

public final class Executive
    extends Employee {
    private String title;
    private double bonus;
    //instance initialization
    {
        title = "";
        bonus = 0;
    }
    //the no-argument constructor
    public Executive(){}
    /**
     * Executive canonical constructor that takes
     * @param title the title of the executive
     * @param name the name of the executive
     * @param salary the base salary of the executive*/
    public Executive(String title, String name, double salary){
        this.title = title;
        this.name = name;
        this.salary = salary;
    }
    /**
     * @param title the title of the executive
     * @param salary the base salary of the executive*/
    public Executive(String title, double salary){
        this.title = title;
        this.salary = salary;
    }
    /**
     * @return <em>String</em> the title of the exec*/
    public String getTitle(){
        return this.title;
    }
    /**
     * set the bonus of the exec
     * @param bonus the bonus amount to add to basic salary*/
    public void setBonus(double bonus){
        this.bonus = bonus;
        this.salary += this.bonus;
    }
    /**
     * set the title of the exec
     * @param title the title of the exec */
    public void setTitle(String title){
        this.title = title;
    }
    /**
     * overrides the Employee getSalary() method
     * @return <em>double</em> the final salary of the exec*/
    @Override
    public double getSalary(){
        return this.salary;
    }

    public double getBonus(){
        return this.bonus;
    }
    /**
     * check whether the passed object is equal to this object
     * @return <em>boolean</em> true if they match else false*/
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;

        if (!(otherObject instanceof Executive other)) return false;
        return  (title.equals(other.title) && bonus == other.bonus);
    }
    /**
     * hashCode method returns the hashcode of the object
     * @return <em>int</em> hashcode of the object*/
    @Override
    public int hashCode(){
        return Objects.hash(title, bonus);
    }
    //unit test
    /**
     * @param args array args from console*/
    public static void main(String[] args){
        Executive boss = new Executive("CEO", "kamar", 256000);
        boss.setBonus(500);
        System.out.printf("%s %s %s %s\n", boss.getTitle(), boss.getSalary(), boss.getId(), boss.getName());
        System.out.printf("%s\n", boss.getHireDay());
        var kamar = new Executive();
        var baraka = new Employee("baraka", 25000, LocalDate.now());
        var you = new Executive("CEO", "kamar", 256000);
        you.setBonus(500);

        Executive me = null;

        System.out.printf("%s %s\n", boss.equals(you), boss.hashCode() == you.hashCode());

        //double bonus = kamar instanceof Executive exec ? exec.getBonus() : 0;

        /*String out = switch (kamar){
            case Executive exe -> "an executive wit title %s ".formatted(exe.getTitle());
            case Manager man -> "a manager with a bonus %,.2f".formatted(man.getSalary());
            default -> "an employee with a salary %,.2f".formatted(kamar.getSalary());
        };*/

    }
}
