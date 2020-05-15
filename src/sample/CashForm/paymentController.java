package sample.CashForm;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.ConnectionSQL.ConnectionUtil;
import sample.user.User;

import java.io.IOException;
import java.sql.*;

public class paymentController {

    Connection con = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;


    public paymentController(){
        this.con = ConnectionUtil.conDB();
    }

    public void payment(String pin, String money) throws SQLException {

        String sql = "UPDATE cash_machine.BankAccount SET Balance = Balance -? WHERE PIN = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, money);
        ps.setString(2, pin);
        ps.executeUpdate();


    }


    public void clickPayment100(MouseEvent mouseEvent) throws SQLException {
        payment(User.PIN(),"100");

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

    public void clickPayment150(MouseEvent mouseEvent) throws SQLException {
        payment(User.PIN(),"150");

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

    public void clickAnotherPayment(MouseEvent mouseEvent) throws IOException {
        Node node = (Node)mouseEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/differentPayment/dPaymentScene.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void clickPayment20(MouseEvent mouseEvent) throws SQLException {
        payment(User.PIN(),"20");

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

    public void clickPayment50(MouseEvent mouseEvent) throws SQLException {
        payment(User.PIN(),"50");

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

    public void clickPayment80(MouseEvent mouseEvent) throws SQLException {
        payment(User.PIN(),"80");

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

