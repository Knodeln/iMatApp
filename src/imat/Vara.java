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


public class Vara extends AnchorPane {

    @FXML
    private Label nameLabel;
    @FXML
    private Label prizeLabel;
    @FXML
    private ImageView imageView;

    private Model model = Model.getInstance();

    private final static double kImageWidth = 100.0;
    private final static double kImageRatio = 0.75;

    private Product product;
    public Vara(Product product){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vara.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.product = product;
        nameLabel.setText(product.getName());
        prizeLabel.setText(String.format("%.2f", product.getPrice()) + " " + product.getUnit());
        imageView.setImage(model.getImage(product));

    }
    @FXML
    private void handleAddAction(ActionEvent event) {
        System.out.println("Add " + product.getName());
        model.addToShoppingCart(product);
        String cartText = "";

        ShoppingCart shoppingCart = Model.getInstance().getShoppingCart();

        System.out.println("before " + cartText + shoppingCart.getItems().size());
        for (ShoppingItem item: shoppingCart.getItems()) {

            cartText = cartText + item.getProduct().getName() + " " + item.getAmount() + "\n";

            System.out.println("during " + cartText);
        }
    }
}
