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
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {
    private Stage window;     //stage for primaryStage
    private Scene MainScene;  //scene of window(primary stage)
    static int count = 0;     //variable used in showing doctors list in patient scene
    static boolean is_signed_in=false;    //variable use in checking if the manger is signed in or not
    //array to contain doctors objects which will be add by manger
    private ArrayList<Doctor> arr = new ArrayList<Doctor>();

    //main method(start of execution)
    public static void main(String[] args) {
        launch(args);
    }

    //override start method in parent class(Application)
    @Override
    public void start(Stage primaryStage) {
        //manger account(which will used to access AddingDoctor scene)
        Manger m1 = new Manger("ahmed", 40, "123", "bla bla bla", 10000);

        window = primaryStage;
        window.setTitle("Clinic program");
        window.getIcons().add(new Image("https://simg.nicepng.com/png/small/457-4579873_mobile-clinic-health-icons.png"));

        //////////////MAIN Scene////////////////////////
        VBox layout = new VBox(20);
        Label label = new Label("choose your state !!");
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 20pt;");
        Button mangerButton = new Button("Manger");
        Button PatientButton = new Button("Patient");
        //adding all nodes to its pane
        layout.getChildren().addAll(label, mangerButton, PatientButton);
        layout.setAlignment(Pos.CENTER);
        MainScene = new Scene(layout, 500, 500);
        window.setScene(MainScene);

        //////////////Manger form(login for manger)////////////////////////
        GridPane layout2 = new GridPane();
        layout2.setPadding(new Insets(10, 10, 10, 10));
        layout2.setVgap(10);
        layout2.setHgap(8);
        //manger name label
        Label nameLabel = new Label("Manger Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        //manger name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 0);
        //manger pass label
        Label PassLabel = new Label("Password:");
        GridPane.setConstraints(PassLabel, 0, 1);
        //manger pass input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);
        //login button
        Button logIn = new Button("LogIn");
        GridPane.setConstraints(logIn, 1, 2);
        //back to main scene button
        Button backButton1 = new Button("back");
        GridPane.setConstraints(backButton1, 1, 3);
        //warning label it's value change if manger enter not valid name and pass
        Label warning_form = new Label();
        GridPane.setConstraints(warning_form, 1, 4);
        //adding all nodes to its pane
        layout2.getChildren().addAll(nameLabel, nameInput, PassLabel, passInput, logIn, backButton1, warning_form);
        Scene mangerFormScene = new Scene(layout2, 500, 500);

        //////////////Patient Scene(show information about available doctors)////////////////////////
        VBox PatientLayout = new VBox(20);
        Label firstLine = new Label("Information of available Doctors :");
        firstLine.setStyle("-fx-font-weight: bold;-fx-font-size: 10pt;");
        //label display no of available doctors
        Label noOfDoc=new Label("No of available Doctors: " +Doctor.getNo_doctors());
        //back to main scene button
        Button backButton2 = new Button("back");
        //adding all nodes to its pane
        PatientLayout.getChildren().addAll(firstLine, backButton2,noOfDoc);
        Scene PatientScene = new Scene(PatientLayout, 500, 500);

        ////////////////////adding doctors/////////////////////
        GridPane AddingDoctorsLayout = new GridPane();
        Label instruction = new Label("fill the information then click add");
        GridPane.setConstraints(instruction, 0, 0);
        instruction.setStyle("-fx-font-weight: bold;-fx-font-size: 10pt;");
        AddingDoctorsLayout.setPadding(new Insets(10, 10, 10, 10));
        AddingDoctorsLayout.setVgap(10);
        AddingDoctorsLayout.setHgap(8);
        //doctor name label
        Label DoctorNameLabel = new Label("Doctor Name:");
        GridPane.setConstraints(DoctorNameLabel, 0, 1);
        //doctor name input
        TextField DoctorNameInput = new TextField();
        DoctorNameInput.setPromptText("name");
        GridPane.setConstraints(DoctorNameInput, 1, 1);
        //doctor Spec Label
        Label SpecLabel = new Label("Specialization:");
        GridPane.setConstraints(SpecLabel, 0, 2);
        //doctor spec input
        TextField SpecInput = new TextField();
        SpecInput.setPromptText("Specialization");
        GridPane.setConstraints(SpecInput, 1, 2);
        //doctor Age Label
        Label AgeLabel = new Label("Age:");
        GridPane.setConstraints(AgeLabel, 0, 3);
        //doctor Age input
        TextField AgeInput = new TextField();
        AgeInput.setPromptText("Age");
        GridPane.setConstraints(AgeInput, 1, 3);

        //doctor day_of_clinic Label
        Label day_of_clinicLabel = new Label("day of clinic:");
        GridPane.setConstraints(day_of_clinicLabel, 0, 4);
        //doctor day_of_clinic input
        TextField day_of_clinicInput = new TextField();
        day_of_clinicInput.setPromptText("day of clinic:");
        GridPane.setConstraints(day_of_clinicInput, 1, 4);

        //doctor address Label
        Label addressLabel = new Label("address:");
        GridPane.setConstraints(addressLabel, 0, 5);
        //doctor address input
        TextField addressInput = new TextField();
        addressInput.setPromptText("address:");
        GridPane.setConstraints(addressInput, 1, 5);
        //button to adding doctor info(as object) to array that contain all available doctors
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 1, 6);
        //back to main scene button
        Button backButton3 = new Button("back to main Window");
        GridPane.setConstraints(backButton3, 0, 7);
        //button to log out manger
        Button logOutButton = new Button("Log out");
        GridPane.setConstraints(logOutButton, 0, 8);
        //label that update if manger add doctor (label updated with doctor name)
        Label info=new Label();
        GridPane.setConstraints(info, 0, 9);
        //adding all nodes to its pane
        AddingDoctorsLayout.getChildren().addAll(instruction, DoctorNameLabel, DoctorNameInput, SpecLabel, SpecInput, AgeLabel, AgeInput,
                day_of_clinicLabel, day_of_clinicInput, addressLabel, addressInput, addButton, backButton3,logOutButton,info);
        Scene AddingDoctorsScene = new Scene(AddingDoctorsLayout, 500, 500);

///////////////////////////////////events and handlers//////////////////////////////////////////////////////////
        mangerButton.setOnAction(e -> {
            if(!is_signed_in){ window.setScene(mangerFormScene);}
            else{
                window.setScene(AddingDoctorsScene);
            }
        });
        PatientButton.setOnAction(e -> {
            for (int i = count; i < arr.size(); i++) {
                GridPane smallLayout = new GridPane();
                doctor_info_pane(smallLayout,i);
                PatientLayout.getChildren().add(smallLayout);
                //count used so no Repetition happen when display doctor info than exist in array of available doctors
                count = i + 1;
            }

            window.setScene(PatientScene);
        });
        backButton1.setOnAction(e -> {
            click_back_button(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
            warning_form.setText("");
        });
        backButton2.setOnAction(e -> {
            click_back_button(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
        });
        backButton3.setOnAction(e -> {
            click_back_button(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
            info.setText("");
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
                click_back_button(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
                info.setText("");
            }
        });
        if ((DoctorNameInput.getText().equals("")) & (SpecInput.getText().equals("")) & (AgeInput.getText().equals("")) & (day_of_clinicInput.getText().equals("")) & (addressInput.getText().equals(""))) {
            addButton.setOnAction(e -> {
                arr.add(new Doctor(DoctorNameInput.getText(), Integer.parseInt(AgeInput.getText()), addressInput.getText(), SpecInput.getText(), day_of_clinicInput.getText()));
                noOfDoc.setText("No of available Doctors: " +Doctor.getNo_doctors());
                info.setText("you added dr."+DoctorNameInput.getText());
                System.out.println("No of available Doctors: " +Doctor.getNo_doctors());
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
    private void click_back_button(TextField nameInput, TextField passInput, TextField doctorNameInput, TextField specInput, TextField ageInput, TextField day_of_clinicInput, TextField addressInput){
        clear( nameInput, passInput,  doctorNameInput,  specInput,  ageInput,  day_of_clinicInput,  addressInput);
        window.setScene(MainScene);
    }
    private void doctor_info_pane(GridPane smallLayout,int i){
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
    }
}
