package imat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;
import javafx.scene.image.ImageView;
import se.chalmers.cse.dat216.project.ShoppingCart;
import se.chalmers.cse.dat216.project.ShoppingItem;


public class VarukorgVara extends AnchorPane {

    @FXML
    private Label nameLabel;
    @FXML
    private Label prizeLabel;


    private Model model = Model.getInstance();


    private ShoppingItem shoppingItem;
    public VarukorgVara(ShoppingItem shoppingItem){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("varukorgVara.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.shoppingItem = shoppingItem;
        nameLabel.setText(shoppingItem.getProduct().getName());
        prizeLabel.setText(String.format("%.2f", shoppingItem.getProduct().getPrice()) + " " + shoppingItem.getProduct().getUnit());

    }
    @FXML
    private void handleAddAction(ActionEvent event) {
        System.out.println("Add " + shoppingItem.getProduct().getName());
        model.addToShoppingCart(shoppingItem.getProduct());
        String cartText = "";

        ShoppingCart shoppingCart = Model.getInstance().getShoppingCart();

        System.out.println("before " + cartText + shoppingCart.getItems().size());
        for (ShoppingItem item: shoppingCart.getItems()) {

            cartText = cartText + item.getProduct().getName() + " " + item.getAmount() + "\n";

            System.out.println("during " + cartText);
        }
    }
}
