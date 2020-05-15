package sample.addUserPanel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.ConnectionSQL.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addUserController implements Initializable {


    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtSecondName;
    @FXML
    private TextField txtAddres;


    PreparedStatement preparedStatement;
    Connection connection = (Connection) ConnectionUtil.conDB();

    @FXML
    private SplitPane parent;

    double x = 0, y = 0;

    private void makeDragable(){
        parent.setOnMousePressed(((mouseEvent) ->{
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        }));

        parent.setOnMouseDragged(((mouseEvent) -> {
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
            stage.setOpacity(0.8f);

        }));

        parent.setOnDragDone(((dragEvent) -> {
            Stage stage = (Stage) ((Node) dragEvent.getSource()).getScene().getWindow();
            stage.setOpacity(1.0f);
        }));

        parent.setOnMouseReleased(((mouseEvent) -> {
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setOpacity(1.0f);

        }));

    }

    public void handleClicksHome(MouseEvent mouseEvent) {
    }

    public void handleClicksPatient(MouseEvent mouseEvent) {
    }

    public void handleClicksAddToDataBase(MouseEvent mouseEvent) {
            saveData();
    }


        //save data with database HosptalDB and table Patient
        private String saveData(){
            try {
                String st = "INSERT INTO cash_machine.Customer\n" +
                        "(CustomerID,\n" +
                        "Name,\n" +
                        "Surname,\n" +
                        "Phone,\n" +
                        "Addres)\n" +
                        "VALUES\n" +
                        "(?,\n" +
                        "?,\n" +
                        "?,\n" +
                        "?,\n" +
                        "?);\n";
                preparedStatement = (PreparedStatement)this.connection.prepareStatement(st);
                preparedStatement.setString(1, txtID.getText());
                preparedStatement.setString(2, txtFirstName.getText());
                preparedStatement.setString(3, txtSecondName.getText());
                preparedStatement.setString(4, txtPhone.getText());
                preparedStatement.setString(5, txtAddres.getText());
                preparedStatement.executeUpdate();
                lblStatus.setVisible(true);
                lblStatus.setTextFill(Color.GREEN);
                lblStatus.setText("Dodanie danych do bazy powiodło się");
                return "Success";
            }catch (SQLException var2){
                System.out.println(var2.getMessage());
                lblStatus.setVisible(true);
                lblStatus.setTextFill(Color.TOMATO);
                lblStatus.setText(var2.getMessage());
                return "Exception";
            }
        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        makeDragable();
    }
}
