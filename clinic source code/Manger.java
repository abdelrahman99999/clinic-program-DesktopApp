package sample;

public class Manger extends Person{
private float Salary;
private String password;
public Manger(String name, int age,String Pass, String address, float salary) {
        super(name, age, address);
        Salary = salary;
        password=Pass;
        }

public String getPassword() {
        return password;
        }

public void setPassword(String password) {
        this.password = password;
        }

public Manger() {
        this("name is Unknown",30,"Admin","address is unknown",7000);
        }

public float getSalary() {
        return Salary;
        }

public void setSalary(float salary) {
        Salary = salary;
        }
        }
