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

public class chooseController{

    Connection con = null;
    ResultSet resultSet = null;

    chooseController(){
        this.con = ConnectionUtil.conDB();
    }

    public void clickPayment50(MouseEvent mouseEvent) {
        try {
            payment();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Błąd pobrania pieniędzy");
        }

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

    public void payment() throws SQLException {
        String sql = "UPDATE cash_machine.BankAccount SET Balance = Balance -? WHERE PIN = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "50");
        ps.setString(2, User.PIN());
        ps.executeUpdate();
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
        Scene scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("sample/BalanceForm/balanceSScene.fxml")));
        stage.setScene(scene);
        stage.show();
    }


}
