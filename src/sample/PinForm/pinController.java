package sample.PinForm;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.nipForm.nipController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.ConnectionSQL.ConnectionUtil;
import sample.user.User;
import sample.nipForm.nipController;

public class pinController implements Initializable {



    @FXML
    private PasswordField txtPin;

    @FXML
    private Label txtError;

    @FXML
    private Label txtPr;

    private String PIN;

    int c = 3;
    Statement statement = null;
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;



    public pinController(){
        this.con = ConnectionUtil.conDB();
    }

    private String savePin(){
        String PIN = txtPin.getText().toString();
        return PIN;
    }



    private boolean logIn(){
        String PIN = txtPin.getText().toString();
        String sql = "SELECT * FROM cash_machine.BankAccount WHERE PIN = ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, PIN);
            resultSet = preparedStatement.executeQuery();
            String psString = resultSet.toString();
            System.out.println(psString);
            //System.out.println(psString);
            if(!resultSet.next()){
                txtError.setText("Wprowadź PIN");
                System.out.println("Zły PIN");
                return false;
            }else {
                System.out.println("PIN poprawny ");
                return true;
            }
        }catch (SQLException var5){
            System.err.println(var5.getMessage());
            return false;
        }
    }

    private String userPin(){
        String pin = this.txtPin.getText();
        return pin;
    }


    public void click1(MouseEvent mouseEvent) {

        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "1";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click2(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "2";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click3(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "3";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click4(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "4";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click5(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "5";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click6(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "6";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click7(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "7";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click8(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "8";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click9(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "9";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click0(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 3) {
            String set = "0";
            txtPin.setText(oldvalue + set);
        }
    }

    public void clickNext(MouseEvent mouseEvent) {
        if(logIn() == true){
            try {
                Node node = (Node)mouseEvent.getSource();
                Stage stage = (Stage)node.getScene().getWindow();
                stage.close();
                Scene scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/ChooseForm/cashScene.fxml")));
                stage.setScene(scene);
                stage.show();
            }catch (IOException var5){
                System.err.println(var5.getMessage());
            }
        }
        else {
            txtError.setText("ŹLE");
            txtPin.clear();
            c -= 1;
            System.out.println(c);
            if(c != 0){
                txtPr.setVisible(true);
                txtPr.setText("Pozostał " + c);
            }else {
                Node node = (Node)mouseEvent.getSource();
                Stage stage = (Stage)node.getScene().getWindow();
                stage.close();
                Scene scene = null;
                try {
                    scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/PinForm/blockScene.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    public void clickBack(MouseEvent mouseEvent) {
        String url = "https://www.youtube.com/watch?v=17mRqrKAyWs";
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("xdg-open " + url);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtPr.setVisible(false);
        if(this.con == null){
            System.out.println("Brak połączenia z bazą");
        }else
            System.out.println("Połączenie z bazą");
    }
}
