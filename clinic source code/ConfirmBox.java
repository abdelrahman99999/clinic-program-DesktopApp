package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public
class ConfirmBox {
    static boolean result;
    public  static void display(String title,String message){
        Stage Window=new Stage();
        Window.setTitle(title);

        //we are going to block input events or user interaction with other windows
        Window.initModality(Modality.APPLICATION_MODAL);

        Label label2=new Label(message);
        Button YesButton=new Button("yes");
        Button NoButton=new Button("cancel");
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

