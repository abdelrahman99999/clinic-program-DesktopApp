package sample;

public class Manger extends Person{
private float Salary;
private String password;
private boolean signed_in;
public Manger(String name, String age,String Pass, String address, float salary) {
        super(name, age, address);
        Salary = salary;
        password=Pass;
        signed_in=false;
        }

public String getPassword() {
        return password;
        }

public void setPassword(String password) {
        this.password = password;
        }

public Manger() {
        this("name is Unknown","30","Admin","address is unknown",7000);
        }

public float getSalary() {
        return Salary;
        }

public void setSalary(float salary) {
        Salary = salary;
        }

        public boolean is_signed_in() {
                return signed_in;
        }

        public void set_signed_in(boolean is_signed_in) {
                this.signed_in = is_signed_in;
        }
}
