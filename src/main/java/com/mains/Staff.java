package com.mains;

import com.classes.practice.Executive;
import com.classes.practice.Manager;

import java.time.LocalDate;
import java.util.*;

/**
 * a simple java program to store staff information of a company.
 * the staff object stores the number and information of {@link Employee}s in the company.
 * the staff object has methods {@code  add()}, {@code get()} and {@code  getStaff()}.
 * the add method takes an employee object as argument and adds it to itself.
 * @author kamar baraka
 * @version 1.1
 * @since 21/05/2023 17:00
 * */

public class Staff {
    private final List<Employee> members = new ArrayList<>();
    private String office;

    {
        office = "";
    }

    //constructor
    /**
     * @param office the office of the staff*/
    public Staff(String office){
        this.office = office;
    }
    /**
     * @param employees employees to add to staff*/
    public Staff(Employee... employees){
        for (Employee eachEmployee : employees)
            add(eachEmployee);
    }
    /**
     * @param employee the employee object/s you wish to store.
     * */
    public Staff(String office, Employee... employee){
        this.office = office;
        for (Employee eachEmployee : employee)
            add(eachEmployee);
    }

    /**@param employee
     * takes an employee object as parameter*/
    public void add(Employee employee){
        members.add(employee);
    }
    /**@param name supply the name of the employee
     * @return Employee the employee object*/
    public Employee get(String name){
        Employee employee = null;
        for (Employee each : members)
            if (each.getName().equalsIgnoreCase(name))
                employee = each;
        return employee;
    }
    /**
     * gets the office of the current staff instance
     * @return string representation of the staff office*/
    public String getOffice(){
        return this.office;
    }
    /**
     * gets all the members of the current instance of staff object
     * @return string representation of the members*/
    public String getMembers(){
        StringBuilder tempString = new StringBuilder();
        for (Employee eachMember : members)
            tempString.append(eachMember.getName() + ", ");
        var finalString = tempString.toString();
        return "%s[ %s ]".formatted(getClass().getSimpleName(), finalString);
    }
    public void setOffice(String office){
        this.office = office;
    }
    /**
     * @return string representation of the staff object*/
    @Override
    public String toString(){
        return "%s[ office= %s, members= %s]".formatted(getClass().getSimpleName(), this.office,
                this.members);
    }
    /**
     * compares two staff objects and returns true if equal else false
     * @param otherObject the object to compare with
     * @return true if equal else false*/
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Staff other)) return false;

        return office.equals(other.getOffice()) && Objects.equals(this.members, other.members);
    }
    /**
     * computes the hashCode of this object
     * @return int hashCode of the object*/
    @Override
    public int hashCode(){
        return Objects.hash(members.hashCode(), office.hashCode());
    }
    //unit test
    public static void main(String[] args){
        Employee emp = new Employee("kamar", 25000);
        Executive exec = new Executive("CIO", "baraka", 50000);
        Manager mgr = new Manager("kahindi", 25600, LocalDate.now());

        Staff staff = new Staff("Admin", emp, exec, mgr);
        System.out.println(staff.getMembers());
    }
}

