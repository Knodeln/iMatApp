
package imat;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.scene.traversal.ParentTraversalEngine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.CartEvent;
import se.chalmers.cse.dat216.project.CreditCard;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingCart;
import se.chalmers.cse.dat216.project.ShoppingCartListener;

public class MainViewController implements Initializable, ShoppingCartListener {

    @FXML
    private SplitPane lowerVerticalSplitPane;
    @FXML
    private FlowPane productsFlowPane;
    @FXML
    private FlowPane varukorgFlowPane;

    private Model model = Model.getInstance();
    @FXML
    private Button tillbaka_varukorg_button;
    @FXML
    private Button varukorg_button;
    @FXML
    private TextField searchField;
    @FXML
    private ListView shoppingCart;

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

        model.getShoppingCart().addShoppingCartListener(this);

        String iMatDirectory = iMatDataHandler.imatDirectory();

        updateProductList(model.getProducts());

        updateVarukorgList(model.getShoppingCart().getItems());

    }

    private void updateProductList(List<Product> products) {

        try {
            System.out.println("updateProductList " + products.size());
            productsFlowPane.getChildren().clear();

            for (Product product : products) {

                productsFlowPane.getChildren().add(new Vara(product));
            }
        }
        catch (Exception e) {

        }
    }

    public void updateVarukorgList(List<se.chalmers.cse.dat216.project.ShoppingItem> shoppingCartItems) {

        try {
            varukorgFlowPane.getChildren().clear();

            for (se.chalmers.cse.dat216.project.ShoppingItem varukorgVara : shoppingCartItems) {

                varukorgFlowPane.getChildren().add(new VarukorgVara(varukorgVara));
            }
        }
        catch (Exception e) {

        }
    }

    @FXML
    private void handleSearchAction(ActionEvent event) {

        List<Product> matches = model.findProducts(searchField.getText());
        updateProductList(matches);
        System.out.println("# matching products: " + matches.size());

    }

    @Override
    public void shoppingCartChanged(CartEvent cartEvent) {
        updateVarukorgList(model.getShoppingCart().getItems());
    }
}