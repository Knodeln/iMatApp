
package imat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewController implements Initializable {

        @FXML
        private SplitPane lowerVerticalSplitPane;
        @FXML
        private Label pathLabel;

        @FXML
        private Button varukorg_button;
        @FXML
        private Button tillbaka_varukorg_knapp;



    IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();

    public void varukorg_button_press() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("varukorg_app.fxml"));
        Stage window = (Stage) varukorg_button.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }

    public void tillbaka_varukorg() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("imat_app.fxml"));
        Stage window = (Stage) tillbaka_varukorg_knapp.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }
    public void initialize(URL url, ResourceBundle rb) {

        String iMatDirectory = iMatDataHandler.imatDirectory();

    }

}