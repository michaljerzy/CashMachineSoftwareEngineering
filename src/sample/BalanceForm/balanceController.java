package sample.BalanceForm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.ConnectionSQL.ConnectionUtil;
import sample.user.User;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class balanceController implements Initializable {

    @FXML
    private TextField txtBalance;

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public balanceController(){
        this.con = ConnectionUtil.conDB();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String pin = "4321";
        try {
            PreparedStatement selectStatement = con.prepareStatement("select * from cash_machine.BankAccount where PIN = ?");
            selectStatement.setString(1, pin);
            ResultSet rs = null;
            rs = selectStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("Balance");
                System.out.println(name);
                txtBalance.setText(name);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void clickBack(MouseEvent mouseEvent) throws IOException {
        Node node = (Node)mouseEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/ChooseForm/cashScene.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}
