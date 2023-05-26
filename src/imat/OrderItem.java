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


public class OrderItem extends AnchorPane {

    @FXML
    Label nameLabel;
    @FXML
    Label prizeLabel;

    @FXML
    Label numberLabel;


    private Model model = Model.getInstance();


    private ShoppingItem shoppingItem;
    public OrderItem(ShoppingItem shoppingItem){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orderItem.fxml"));
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
}
