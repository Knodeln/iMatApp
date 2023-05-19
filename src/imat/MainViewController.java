
package imat;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.scene.traversal.ParentTraversalEngine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;

public class MainViewController implements Initializable {

    @FXML
    private SplitPane lowerVerticalSplitPane;
    @FXML
    private FlowPane productsFlowPane;

    private Model model = Model.getInstance();
    @FXML
    private Button tillbaka_varukorg_button;
    @FXML
    private Button varukorg_button;

    IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();

    public void tillbaka_varukorg_button_press() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("imat_app.fxml"));
        Stage window = (Stage) tillbaka_varukorg_button.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));

    }
    public void varukorg_button_press() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("varukorg_app.fxml"));
        Stage window = (Stage) varukorg_button.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));

    }
    public void initialize(URL url, ResourceBundle rb) {

        String iMatDirectory = iMatDataHandler.imatDirectory();

        updateProductList(model.getProducts());

    }

    private void updateProductList(List<Product> products) {

        System.out.println("updateProductList " + products.size());
        productsFlowPane.getChildren().clear();

        for (Product product : products) {

            productsFlowPane.getChildren().add(new Vara(product));
        }

    }

}