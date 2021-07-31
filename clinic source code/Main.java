package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main extends Application {
    //manger account(which will used to access AddingDoctor scene)
    Manger m1 = new Manger("ahmed", "40", "123", "bla bla bla", 10000);

    private Stage window;     //stage for primaryStage
    private Scene MainScene;  //scene of window(primary stage)
    static int count = 0;     //variable used in showing doctors list in patient scene
    //array to contain doctors objects which will be add by manger
    static ArrayList<Doctor> arr = new ArrayList<Doctor>();

    //main method(start of execution)
    public static void main(String[] args) {
        launch(args);
    }

    //override start method in parent class(Application)
    @Override
    public void start(Stage primaryStage)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window = primaryStage;
        window.setTitle("Clinic program");
        window.getIcons().add(new Image("https://simg.nicepng.com/png/small/457-4579873_mobile-clinic-health-icons.png"));

        //////////////MAIN Scene////////////////////////
        VBox MainLayout = new VBox(20);
        main_scene_pane(MainLayout);
        MainScene = new Scene(MainLayout, 500, 500);
        window.setScene(MainScene);

        //////////////Manger form(login for manger)///////
        GridPane layout2 = new GridPane();
        login_form_pane(layout2);
        Scene mangerFormScene = new Scene(layout2, 500, 500);

        ///////////////Patient Scene(show information about available doctors)////////////
        VBox PatientLayout = new VBox(20);
        patient_scene_pane(PatientLayout);
        //PatientLayout.getChildren().removeAll();
        Scene PatientScene = new Scene(PatientLayout, 500, 500);

        ////////////////////adding doctors/////////////////////
        GridPane AddingDoctorsLayout = new GridPane();
        add_doctors_pane(AddingDoctorsLayout);
        Scene AddingDoctorsScene = new Scene(AddingDoctorsLayout, 500, 500);


///////////////////////////////////events and handlers//////////////////////////////////////////////////////////

        mangerButton.setOnAction(e -> {
            if(!m1.is_signed_in()){ window.setScene(mangerFormScene);}
            else{
                window.setScene(AddingDoctorsScene);
            }
        });

        PatientButton.setOnAction(e -> {
            System.out.println(arr.size());
            for (int i = count; i < arr.size(); i++) {
                GridPane smallLayout = new GridPane();
                doctor_info_pane(smallLayout,i);
                PatientLayout.getChildren().add(smallLayout);
                //count used so no Repetition happen when display doctor info than exist in array of available doctors
               count ++;
               noOfDoc.setText("No of available Doctors: " +Doctor.getNo_doctors());
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
                m1.set_signed_in(true);
                warning_form.setText("");
                clear(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
            } else {
                warning_form.setText("please,try enter again");
            }
        });

        logOutButton.setOnAction(e->{
            ConfirmBox.display("Warning!","Are you sure you want to log out?");
            if(ConfirmBox.getResult()) {
                m1.set_signed_in(false);
                click_back_button(nameInput,passInput,DoctorNameInput,SpecInput,AgeInput,day_of_clinicInput,addressInput);
                info.setText("");
            }
        });

        if ((DoctorNameInput.getText().equals("")) & (SpecInput.getText().equals("")) & (AgeInput.getText().equals("")) & (day_of_clinicInput.getText().equals("")) & (addressInput.getText().equals(""))) {
            addButton.setOnAction(e -> {
                arr.add(new Doctor(DoctorNameInput.getText(), AgeInput.getText(), addressInput.getText(), SpecInput.getText(), day_of_clinicInput.getText()));
                try{
                    FileWriter myWriter =new FileWriter("C:\\Users\\boody\\Desktop\\doctors.txt",true);
                    myWriter.write(DoctorNameInput.getText()+" , "+Integer.parseInt(AgeInput.getText())+" , "+ SpecInput.getText()+" , "+day_of_clinicInput.getText()+" , "+ addressInput.getText()+"\n");
                    myWriter.close();
                }catch (Exception ee){
                    System.out.println("an error occurs");
                }

                noOfDoc.setText("No of available Doctors: " +Doctor.getNo_doctors());
                info.setText("you added dr ."+DoctorNameInput.getText());
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
    private void login_form_pane(GridPane layout2){
        layout2.setPadding(new Insets(10, 10, 10, 10));
        layout2.setVgap(10);
        layout2.setHgap(8);
        //manger name label
        GridPane.setConstraints(nameLabel, 0, 0);
        //manger name input
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 0);
        //manger pass label
        GridPane.setConstraints(PassLabel, 0, 1);
        //manger pass input
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);
        //login button
        GridPane.setConstraints(logIn, 1, 2);
        //back to main scene button
        GridPane.setConstraints(backButton1, 1, 3);
        //warning label it's value change if manger enter not valid name and pass
        GridPane.setConstraints(warning_form, 1, 4);
        //adding all nodes to its pane
        layout2.getChildren().addAll(nameLabel, nameInput, PassLabel, passInput, logIn, backButton1, warning_form);
    }
    private void add_doctors_pane(GridPane AddingDoctorsLayout){
        GridPane.setConstraints(instruction, 0, 0);
        instruction.setStyle("-fx-font-weight: bold;-fx-font-size: 10pt;");
        AddingDoctorsLayout.setPadding(new Insets(10, 10, 10, 10));
        AddingDoctorsLayout.setVgap(10);
        AddingDoctorsLayout.setHgap(8);
        //doctor name label
        GridPane.setConstraints(DoctorNameLabel, 0, 1);
        //doctor name input
        DoctorNameInput.setPromptText("name");
        GridPane.setConstraints(DoctorNameInput, 1, 1);
        //doctor Spec Label
        GridPane.setConstraints(SpecLabel, 0, 2);
        //doctor spec input
        SpecInput.setPromptText("Specialization");
        GridPane.setConstraints(SpecInput, 1, 2);
        //doctor Age Label
        GridPane.setConstraints(AgeLabel, 0, 3);
        //doctor Age input
        AgeInput.setPromptText("Age");
        GridPane.setConstraints(AgeInput, 1, 3);

        //doctor day_of_clinic Label
        GridPane.setConstraints(day_of_clinicLabel, 0, 4);
        //doctor day_of_clinic input
        day_of_clinicInput.setPromptText("day of clinic:");
        GridPane.setConstraints(day_of_clinicInput, 1, 4);

        //doctor address Label
        GridPane.setConstraints(addressLabel, 0, 5);
        //doctor address input
        addressInput.setPromptText("address:");
        GridPane.setConstraints(addressInput, 1, 5);
        //button to adding doctor info(as object) to array that contain all available doctors
        GridPane.setConstraints(addButton, 1, 6);
        //back to main scene button
        GridPane.setConstraints(backButton3, 0, 7);
        //button to log out manger
        GridPane.setConstraints(logOutButton, 0, 8);
        //label that update if manger add doctor (label updated with doctor name)
        GridPane.setConstraints(info, 0, 9);
        //adding all nodes to its pane
        AddingDoctorsLayout.getChildren().addAll(instruction, DoctorNameLabel, DoctorNameInput, SpecLabel, SpecInput, AgeLabel, AgeInput,
                day_of_clinicLabel, day_of_clinicInput, addressLabel, addressInput, addButton, backButton3,logOutButton,info);
    }
    private void main_scene_pane(VBox MainLayout){
        MainLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 20pt;");
        //adding all nodes to its pane
        MainLayout.getChildren().addAll(MainLabel, mangerButton, PatientButton);
        MainLayout.setAlignment(Pos.CENTER);
    }
    private void patient_scene_pane(VBox PatientLayout){
        firstLine.setStyle("-fx-font-weight: bold;-fx-font-size: 10pt;");
        //adding all nodes to its pane
        PatientLayout.getChildren().addAll(firstLine, backButton2,noOfDoc);
    }

    //////////////pane for Manger form(login for manger)////////////////////////
    //manger name label
    Label nameLabel = new Label("Manger Name:");
    //manger name input
    TextField nameInput = new TextField();
    //manger pass label
    Label PassLabel = new Label("Password:");
    //manger pass input
    TextField passInput = new TextField();
    //login button
    Button logIn = new Button("LogIn");
    //back to main scene button
    Button backButton1 = new Button("back");
    //warning label it's value change if manger enter not valid name and pass
    Label warning_form = new Label();

    ////////////////////pane for adding doctors scene/////////////////////
    Label instruction = new Label("fill the information then click add");
    //doctor name label
    Label DoctorNameLabel = new Label("Doctor Name:");
    //doctor name input
    TextField DoctorNameInput = new TextField();
    //doctor Spec Label
    Label SpecLabel = new Label("Specialization:");
    //doctor spec input
    TextField SpecInput = new TextField();
    //doctor Age Label
    Label AgeLabel = new Label("Age:");
    //doctor Age input
    TextField AgeInput = new TextField();
    //doctor day_of_clinic Label
    Label day_of_clinicLabel = new Label("day of clinic:");
    //doctor day_of_clinic input
    TextField day_of_clinicInput = new TextField();
    //doctor address Label
    Label addressLabel = new Label("address:");
    //doctor address input
    TextField addressInput = new TextField();
    //button to adding doctor info(as object) to array that contain all available doctors
    Button addButton = new Button("Add");
    //back to main scene button
    Button backButton3 = new Button("back to main Window");
    //button to log out manger
    Button logOutButton = new Button("Log out");
    //label that update if manger add doctor (label updated with doctor name)
    Label info=new Label();

    //////////////pane for MAIN Scene////////////////////////
    Label MainLabel = new Label("choose your state !!");
    Button mangerButton = new Button("Manger");
    Button PatientButton = new Button("Patient");

    ///////////////Patient Scene(show information about available doctors)////////////
    Label firstLine = new Label("Information of available Doctors :");
    //label display no of available doctors
    Label noOfDoc=new Label("No of available Doctors: " +Doctor.getNo_doctors());
    //back to main scene button
    Button backButton2 = new Button("back");

}
