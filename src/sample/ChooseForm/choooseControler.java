package sample.ChooseForm;

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

public class choooseControler {

    Statement statement = null;
    Connection con = null;
    //PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    public choooseControler(){
        this.con = ConnectionUtil.conDB();
    }

    String pin = null;

    public void clickPayment50(MouseEvent mouseEvent) throws SQLException {

        String sql = "UPDATE cash_machine.BankAccount SET Balance = Balance -50 WHERE AccountID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, User.PIN());
        ps.executeUpdate();

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

    public void clickPayment(MouseEvent mouseEvent) throws IOException {
        Node node = (Node)mouseEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/CashForm/paymentScene.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void clickBalance(MouseEvent mouseEvent) throws IOException {
        Node node = (Node)mouseEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/BalanceForm/balanceSScene.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}
