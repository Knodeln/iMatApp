
package imat;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.FlowPane;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;

public class MainViewController implements Initializable {

    @FXML
    private SplitPane lowerVerticalSplitPane;
    @FXML
    private FlowPane productsFlowPane;

    private Model model;

    IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();

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