package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;


class Person{
    private String name;
    private int age;
    private String address;


    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(){
        this("name is Unknown",30,"address is unknown");
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        this.address = address;
    }

}

class Doctor extends Person{
    private String Specialization;
    private String Day_of_clinic;
    public static int no_doctors;

    public Doctor(String name, int age, String address, String specialization, String day_of_clinic) {
        super(name, age, address);
        Specialization = specialization;
        Day_of_clinic = day_of_clinic;
        no_doctors++;
    }

    public Doctor() {
        this("Unknown",30,"unknown","Unknown","Unknown");
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
}

class Manger extends Person{
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

class ConfirmBox {
    static boolean result;
    public  static void display(String title,String message){
        Stage Window=new Stage();
        Window.setTitle(title);

        //we are going to block input events or user interaction with other windows
        Window.initModality(Modality.APPLICATION_MODAL);

        Label label2=new Label(message);
        Button YesButton=new Button("Yes");
        Button NoButton=new Button("No");
        YesButton.setOnAction(e->{
            result=true;
            Window.close();

        });
        NoButton.setOnAction(e->{
            result=false;
            Window.close();
        });
        VBox layout2=new VBox(10);
        layout2.getChildren().addAll(label2,YesButton,NoButton);
        layout2.setAlignment(Pos.CENTER);
        Scene scene2=new Scene(layout2,400,200);
        Window.setScene(scene2);
        Window.showAndWait();
    }

    public static boolean getResult() {
        return result;
    }
}

public class Main extends Application {
    static int count = 0;
    static boolean is_signed_in=false;
    public static void main(String[] args) {
        launch(args);
    }

    Stage window;
    @Override
    public void start(Stage primaryStage) {
        Manger m1 = new Manger("ahmed", 40, "123", "bla bla bla", 10000);

        window = primaryStage;
        window.setTitle("Clinic program");
        window.getIcons().add(new Image("https://simg.nicepng.com/png/small/457-4579873_mobile-clinic-health-icons.png"));
        ArrayList<Doctor> arr = new ArrayList<Doctor>();
////////////////////////////////////////////////////////////////////////////////////////
        //////////////MAIN Scene////////////////////////
        VBox layout = new VBox(20);
        Label label = new Label("choose your state !!");
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 20pt;");
        Button mangerButton = new Button("Manger");
        Button PatientButton = new Button("Patient");
        layout.getChildren().addAll(label, mangerButton, PatientButton);
        layout.setAlignment(Pos.CENTER);
        Scene MainScene = new Scene(layout, 500, 500);
        window.setScene(MainScene);
////////////////////////////////////////////////////////////////////////////////////////
        //////////////Manger form////////////////////////
        GridPane layout2 = new GridPane();
        layout2.setPadding(new Insets(10, 10, 10, 10));
        layout2.setVgap(10);
        layout2.setHgap(8);
        //name label
        Label nameLabel = new Label("Manger Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        //name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 0);
        //pass label
        Label PassLabel = new Label("Password:");
        GridPane.setConstraints(PassLabel, 0, 1);
        //name input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);
        //login button
        Button logIn = new Button("LogIn");
        GridPane.setConstraints(logIn, 1, 2);
        Button backButton1 = new Button("back");
        GridPane.setConstraints(backButton1, 1, 3);
        Label warning_form = new Label();
        GridPane.setConstraints(warning_form, 1, 4);
        layout2.getChildren().addAll(nameLabel, nameInput, PassLabel, passInput, logIn, backButton1, warning_form);
        Scene mangerFormScene = new Scene(layout2, 500, 500);

////////////////////////////////////////////////////////////////////////////////////////
        //////////////Patient Scene////////////////////////
        VBox PatientLayout = new VBox(20);
        Label firstLine = new Label("Information of available Doctors :");
        Label noOfDoc=new Label("No of available Doctors: " +Doctor.getNo_doctors());

        firstLine.setStyle("-fx-font-weight: bold;-fx-font-size: 10pt;");
        Button backButton2 = new Button("back");
        PatientLayout.getChildren().addAll(firstLine, backButton2,noOfDoc);

        Scene PatientScene = new Scene(PatientLayout, 500, 500);
/////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////adding doctors/////////////////////
        GridPane AddingDoctorsLayout = new GridPane();
        Label instruction = new Label("fill the information then click add");
        instruction.setStyle("-fx-font-weight: bold;-fx-font-size: 10pt;");
        AddingDoctorsLayout.setPadding(new Insets(10, 10, 10, 10));
        AddingDoctorsLayout.setVgap(10);
        AddingDoctorsLayout.setHgap(8);

        GridPane.setConstraints(instruction, 0, 0);
        //name label
        Label DoctorNameLabel = new Label("Doctor Name:");
        GridPane.setConstraints(DoctorNameLabel, 0, 1);
        //name input
        TextField DoctorNameInput = new TextField();
        DoctorNameInput.setPromptText("name");
        GridPane.setConstraints(DoctorNameInput, 1, 1);
        //Spec Label
        Label SpecLabel = new Label("Specialization:");
        GridPane.setConstraints(SpecLabel, 0, 2);
        //spec input
        TextField SpecInput = new TextField();
        SpecInput.setPromptText("Specialization");
        GridPane.setConstraints(SpecInput, 1, 2);

        //Age Label
        Label AgeLabel = new Label("Age:");
        GridPane.setConstraints(AgeLabel, 0, 3);
        //Age input
        TextField AgeInput = new TextField();
        AgeInput.setPromptText("Age");
        GridPane.setConstraints(AgeInput, 1, 3);

        //day_of_clinic Label
        Label day_of_clinicLabel = new Label("day of clinic:");
        GridPane.setConstraints(day_of_clinicLabel, 0, 4);
        //day_of_clinic input
        TextField day_of_clinicInput = new TextField();
        day_of_clinicInput.setPromptText("day of clinic:");
        GridPane.setConstraints(day_of_clinicInput, 1, 4);

        //address Label
        Label addressLabel = new Label("address:");
        GridPane.setConstraints(addressLabel, 0, 5);
        //address input
        TextField addressInput = new TextField();
        addressInput.setPromptText("address:");
        GridPane.setConstraints(addressInput, 1, 5);


        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 1, 6);
        Button backButton3 = new Button("back to main Window");
        GridPane.setConstraints(backButton3, 0, 7);
        Button logOutButton = new Button("Log out");
        GridPane.setConstraints(logOutButton, 0, 8);
        Label info=new Label();
        GridPane.setConstraints(info, 0, 9);
        AddingDoctorsLayout.getChildren().addAll(instruction, DoctorNameLabel, DoctorNameInput, SpecLabel, SpecInput, AgeLabel, AgeInput,
                day_of_clinicLabel, day_of_clinicInput, addressLabel, addressInput, addButton, backButton3,logOutButton,info);
        Scene AddingDoctorsScene = new Scene(AddingDoctorsLayout, 500, 500);
/////////////////////////////////////////////////////////////////////////////////////////////////////

        mangerButton.setOnAction(e -> {
            if(!is_signed_in){ window.setScene(mangerFormScene);}
            else{
                window.setScene(AddingDoctorsScene);
            }
        });
        PatientButton.setOnAction(e -> {
            for (int i = count; i < arr.size(); i++) {


                GridPane smallLayout = new GridPane();
                smallLayout.setStyle("-fx-background-color:#ffffff;");
                Label l1 = new Label("-----------------------------------------------");
                GridPane.setConstraints(l1, 0, 0);
                Label l2 = new Label("doctor name: ");
                l2.setStyle("-fx-font-size: 10pt;-fx-font-weight: bold;");
                GridPane.setConstraints(l2, 0, 1);
                Label l22 = new Label(arr.get(i).getName());
                GridPane.setConstraints(l22, 1, 1);

                Label l3 = new Label("doctor specialization: ");
                l3.setStyle("-fx-font-size: 10pt;-fx-font-weight: bold;");
                GridPane.setConstraints(l3, 0, 2);
                Label l33 = new Label(arr.get(i).getSpecialization());
                GridPane.setConstraints(l33, 1, 2);

                Label l4 = new Label("Doctor age: ");
                l4.setStyle("-fx-font-size: 10pt;-fx-font-weight: bold;");
                GridPane.setConstraints(l4, 0, 3);
                Label l44 = new Label("" + arr.get(i).getAge());
                GridPane.setConstraints(l44, 1, 3);

                Label l5 = new Label("day of clinic: ");
                l5.setStyle("-fx-font-size: 10pt;-fx-font-weight: bold;");
                GridPane.setConstraints(l5, 0, 4);
                Label l55 = new Label(arr.get(i).getDay_of_clinic());
                GridPane.setConstraints(l55, 1, 4);
                Label l6 = new Label("-----------------------------------------------");
                GridPane.setConstraints(l6, 0, 5);
                smallLayout.getChildren().addAll(l1, l2, l22, l3, l33, l4, l44, l5, l55, l6);
                PatientLayout.getChildren().add(smallLayout);

                count = i + 1;
            }

            window.setScene(PatientScene);
        });
        backButton1.setOnAction(e -> {
            window.setScene(MainScene);
            warning_form.setText("");
            clear(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
        });
        backButton2.setOnAction(e -> {
            window.setScene(MainScene);
            clear(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
        });
        backButton3.setOnAction(e -> {
            window.setScene(MainScene);
            info.setText("");
            clear(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
        });
        logIn.setOnAction(e -> {
            if (nameInput.getText().equals(m1.getName()) & passInput.getText().equals(m1.getPassword())) {
                window.setScene(AddingDoctorsScene);
                is_signed_in=true;
                warning_form.setText("");
                clear(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
            } else {
                warning_form.setText("please,try enter again");
            }
        });
        logOutButton.setOnAction(e->{
            ConfirmBox.display("Warning!","Are you sure you want to log out?");
            if(ConfirmBox.getResult()) {
                is_signed_in = false;
                window.setScene(MainScene);
                info.setText("");
                clear(nameInput, passInput, DoctorNameInput, SpecInput, AgeInput, day_of_clinicInput, addressInput);
            }
        });
        if ((DoctorNameInput.getText().equals("")) & (SpecInput.getText().equals("")) & (AgeInput.getText().equals("")) & (day_of_clinicInput.getText().equals("")) & (addressInput.getText().equals(""))) {
            addButton.setOnAction(e -> {
                arr.add(new Doctor(DoctorNameInput.getText(), Integer.parseInt(AgeInput.getText()), addressInput.getText(), SpecInput.getText(), day_of_clinicInput.getText()));
                noOfDoc.setText("No of available Doctors: " +Doctor.getNo_doctors());
                info.setText("you added dr."+DoctorNameInput.getText());
                System.out.println(Doctor.getNo_doctors());
                clear(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
            });

        }

        window.show();
    }
    private void clear(TextField nameInput, TextField passInput, TextField doctorNameInput, TextField specInput, TextField ageInput, TextField day_of_clinicInput, TextField addressInput) {
        nameInput.clear();
        passInput.clear();
        doctorNameInput.clear();
        specInput.clear();
        ageInput.clear();
        day_of_clinicInput.clear();
        addressInput.clear();
    }
}

