package sample.loadingForm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loadingContreoller implements Initializable {

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label lblEnd;

    @FXML
    private Button butEnd;

    public void clickEnd(MouseEvent mouseEvent) throws IOException {
        Node node = (Node)mouseEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene((Parent) FXMLLoader.load(this.getClass().getResource("/sample/nipForm/nipPanel.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    class bg_Thread implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                progressBar.setProgress(i/100.0);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lblEnd.setVisible(true);
            System.out.println("Tak");
            butEnd.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblEnd.setVisible(false);
        butEnd.setVisible(false);
        Thread th = new Thread(new bg_Thread());
        th.start();
        progressBar.setProgress(0.0);
    }
}
