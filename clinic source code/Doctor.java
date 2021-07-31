package sample;

public class Doctor extends Person{
    private String Specialization;
    private String Day_of_clinic;
    public static int no_doctors;

    public Doctor(String name, String age, String address, String specialization, String day_of_clinic) {
        super(name, age, address);
        Specialization = specialization;
        Day_of_clinic = day_of_clinic;
        no_doctors++;
    }

    public Doctor() {
        this("Unknown","30","unknown","Unknown","Unknown");
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public String getDay_of_clinic() {
        return Day_of_clinic;
    }

    public void setDay_of_clinic(String  day_of_clinic) {
        Day_of_clinic = day_of_clinic;
    }

    public static int getNo_doctors() {
        return no_doctors;
    }
    public static int setNo_doctors(int n) {
        return no_doctors=n;
    }
}
