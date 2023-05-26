import com.kamarbaraka.practice.Employee;
import java.time.LocalDate;

/**
 * this program demonstrates inheritance among classes\
 * @author kamar baraka
 * @version 1.0
 * @since 25/5/2023*/

public class Manager
    extends com.kamarbaraka.practice.Employee {
    private double bonus;
    /**
     *manager canonical constructor constructs a manager object
     * and initializes the inherited employee fields
     * @param name name of the manager
     * @param salary the salary
     * @param hireDay the date of hire*/
    public Manager(String name, double salary, LocalDate hireDay){
        super(name, salary, hireDay);
        bonus = 0;
    }
    /**
     * setBonus mutator method sets the bonus of the manager and adds it to the salary
     * @param bonus the <em>double</em> bonus to be added*/
    public void setBonus(double bonus){
        this.bonus = bonus;
        super.setSalary(this.bonus + super.getSalary());
    }
    /**
     * override the super(Employee) class method to return the new salary(bonus included)
     * @return double salary bonus included*/
    @Override
    public double getSalary(){
        return super.getSalary();
    }
    //unit test
    public static void main(String[] args){
    }
}
