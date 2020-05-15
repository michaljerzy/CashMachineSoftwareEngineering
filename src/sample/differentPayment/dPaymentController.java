package sample.differentPayment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.ConnectionSQL.ConnectionUtil;
import sample.user.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dPaymentController {

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public dPaymentController(){
        this.con = ConnectionUtil.conDB();
    }

    @FXML
    private TextField txtPin;

    public void click1(MouseEvent mouseEvent) {

        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "1";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click2(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "2";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click3(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "3";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click4(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "4";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click5(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "5";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click6(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "6";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click7(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "7";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click8(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "8";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click9(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "9";
            txtPin.setText(oldvalue + set);
        }
    }

    public void click0(MouseEvent mouseEvent) {
        String oldvalue = txtPin.getText();
        if(oldvalue.length() <= 6) {
            String set = "0";
            txtPin.setText(oldvalue + set);
        }
    }

    public void payment() throws SQLException {
        String sql = "UPDATE cash_machine.BankAccount SET Balance = Balance -? WHERE PIN = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, txtPin.getText());
        ps.setString(2, User.PIN());
        ps.executeUpdate();
    }

    public void clickNext(MouseEvent mouseEvent) throws SQLException {
        payment();

        Node node = (Node)mouseEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
        Scene scene = null;
        try {
            scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/loadingForm/loadingPanel.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }
}
