package imat;

import imat.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.ShoppingCart;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;


public class VarukorgVara2 extends AnchorPane {

    @FXML
    Label nameLabel;
    @FXML
    Label prizeLabel;
    @FXML
    Label numberLabel;


    private Model model = Model.getInstance();


    private ShoppingItem shoppingItem;
    public VarukorgVara2(ShoppingItem shoppingItem){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("varukorgVara2.fxml"));
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
        numberLabel.setText("Antal: " + (shoppingItem.getAmount()));
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
    @FXML
    private void handleRemoveAction(ActionEvent event) {
        System.out.println("Add " + shoppingItem.getProduct().getName());
        ShoppingCart cart = model.getShoppingCart();
        double itemsBefore = shoppingItem.getAmount();

        if (itemsBefore > 1.0) {
            //cart.removeItem(shoppingItem);
            cart.addProduct(shoppingItem.getProduct(), (- 1.0));
        }
        else {cart.removeItem(shoppingItem);}
        String cartText = "";

        ShoppingCart shoppingCart = Model.getInstance().getShoppingCart();

        System.out.println("before " + cartText + shoppingCart.getItems().size());
        for (ShoppingItem item: shoppingCart.getItems()) {

            cartText = cartText + item.getProduct().getName() + " " + item.getAmount() + "\n";

            System.out.println("during " + cartText);
        }
    }

}
