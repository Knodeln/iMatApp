package imat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import se.chalmers.cse.dat216.project.Order;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;
import javafx.scene.image.ImageView;
import se.chalmers.cse.dat216.project.ShoppingCart;
import se.chalmers.cse.dat216.project.ShoppingItem;


public class OrderPane extends AnchorPane {

    @FXML
    private Label nameLabel;
    @FXML
    private Label prizeLabel;
    @FXML
    private ImageView imageView;
    @FXML
    private Label kostnadLabel;

    @FXML
    private FlowPane orderItemsFlowPane;

    private Model model = Model.getInstance();

    private Order order;
    public OrderPane(Order order){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orderPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.order = order;
        kostnadLabel.setText("Kostnad: " + kostnadCount());
        updateOrderItemsList();


    }
    public void updateOrderItemsList() {

        try {
            orderItemsFlowPane.getChildren().clear();

            for (ShoppingItem product : order.getItems()) {

                orderItemsFlowPane.getChildren().add(new OrderItem(product));
            }
        }
        catch (Exception e) {

        }
    }

    private double kostnadCount() {
        double kostnad = 0;
        for (ShoppingItem item : order.getItems()) {
            kostnad += (item.getAmount()*item.getProduct().getPrice());
        }
        kostnad = Math.round(kostnad * 100.0) / 100.0;
        return kostnad;
    }
    @FXML
    public void handleLäggTillAction(ActionEvent event) {
        for (ShoppingItem item : order.getItems()) {
            System.out.println("Add " + item.getProduct().getName());
            model.getShoppingCart().addProduct(item.getProduct(), item.getAmount());

        }
    }

}
