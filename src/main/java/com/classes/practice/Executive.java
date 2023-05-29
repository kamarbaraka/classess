package com.classes.practice;

import com.mains.Employee;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

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
    /**
     * provides a string representation of this object
     * @return string representation of Executive*/
    @Override
    public String toString(){
        return "%s[ id= %s, title= %s, name= %s, salary=%,.2f, hireDay= %s, bonus= %s ]\n".formatted(
                getClass().getSimpleName(), this.getId(), this.getTitle(), this.getName(), this.getSalary(),
                this.getHireDay(), this.getBonus()
        );
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
        Object[] ar = new Object[]{"kamar", 23};
        var val = Objects.hash(ar[0], ar[1]) == Arrays.hashCode(ar);

        System.out.println(Arrays.toString(new Object[] {1, 2, "kamar"}));
        Logger.getGlobal().info("hey" + boss);

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
