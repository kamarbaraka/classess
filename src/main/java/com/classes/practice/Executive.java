package com.classes.practice;

import com.mains.Employee;

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
     * @param name the name of the executive
     * @param salary the base salary of the executive*/
    public Executive(String name, double salary){
        this("", name, salary);
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
     * overrides the Employee getSalary() method
     * @return <em>double</em> the final salary of the exec*/
    @Override
    public double getSalary(){
        return this.salary;
    }
    //unit test
    public static void main(String[] args){
        Executive kamar = new Executive("CEO", "kamar", 256000);
        kamar.setBonus(500);
        System.out.printf("%s %s %s %s\n", kamar.getTitle(), kamar.getSalary(), kamar.getId(), kamar.getName());
        System.out.printf("%s", kamar.getHireDay());
    }
}
