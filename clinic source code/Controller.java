package sample;

import javafx.fxml.Initializable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    //this function will be executed at the begining of the program
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Creating an object of a file
            File myObj = new File("C:\\Users\\boody\\Desktop\\doctors.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] words = data.split(",");
                    //ali , 20 , eyes , monday , bla bla bla
                    Main.arr.add(new Doctor(words[0], words[1], words[4], words[2], words[3]));
                }
                myReader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
