package sample.nipForm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class nipController implements Initializable {

    @FXML
    TextField textNip;

    public String getNip() {
        String NIP;
        NIP = textNip.getText();
        return NIP;
    }

    public void click1(MouseEvent mouseEvent) {

        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "1";
            textNip.setText(oldvalue + set);
        }
    }

    public void click2(MouseEvent mouseEvent) {
        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "2";
            textNip.setText(oldvalue + set);
        }
    }

    public void click3(MouseEvent mouseEvent) {
        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "3";
            textNip.setText(oldvalue + set);
        }
    }

    public void click4(MouseEvent mouseEvent) {
        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "4";
            textNip.setText(oldvalue + set);
        }
    }

    public void click5(MouseEvent mouseEvent) {
        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "5";
            textNip.setText(oldvalue + set);
        }
    }

    public void click6(MouseEvent mouseEvent) {
        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "6";
            textNip.setText(oldvalue + set);
        }
    }

    public void click7(MouseEvent mouseEvent) {
        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "7";
            textNip.setText(oldvalue + set);
        }
    }

    public void click8(MouseEvent mouseEvent) {
        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "8";
            textNip.setText(oldvalue + set);
        }
    }

    public void click9(MouseEvent mouseEvent) {
        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "9";
            textNip.setText(oldvalue + set);
        }
    }

    public void click0(MouseEvent mouseEvent) {
        String oldvalue = textNip.getText();
        if(oldvalue.length() <= 25) {
            String set = "0";
            textNip.setText(oldvalue + set);
        }
    }


    public nipController(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void clickNext(MouseEvent mouseEvent) throws IOException {
        System.out.println(getNip());
        Node node = (Node)mouseEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/PinForm/pinScene.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void clickAdd(MouseEvent mouseEvent) throws IOException {
        System.out.println(getNip());
        Node node = (Node)mouseEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/addUserPanel/addUserForm.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}
