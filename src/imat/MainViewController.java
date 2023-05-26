
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
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import se.chalmers.cse.dat216.project.*;
import se.chalmers.cse.dat216.project.Product;

public class MainViewController implements Initializable, ShoppingCartListener {

    @FXML
    private SplitPane lowerVerticalSplitPane;
    @FXML
    private FlowPane productsFlowPane;
    @FXML
    private FlowPane orderItemsFlowPane;
    @FXML
    private FlowPane ordersFlowPane;
    @FXML
    private FlowPane varukorgFlowPane;

    @FXML
    private Button betala_button;


    @FXML
    private Button Imat_button;


    @FXML
    private Label Name;
    @FXML
    public Label antalVarorLabel;
    @FXML
    public Label kostnadLabel;

    @FXML
    private Label efternamn;

    @FXML
    private  Label Adress;

    @FXML
    private  Label post_adress;

    @FXML
    private Label telefonnummer;

    @FXML
    private Label personnummer;

    @FXML
    private Label postnummer;

    @FXML
    private Label Ort;

    @FXML
    private Button tillbaka_till_startsida;
    @FXML
    private Button tillbaka;
    @FXML
    private Button spara_uppgifter;

    @FXML
    private Button fortsätt_till_nästa;

    @FXML
    private Button stäng_knappen;

    @FXML
    private DatePicker Leverans_datum;

    @FXML
    private RadioButton Lämnas_vid_dörr;

    @FXML
    private RadioButton Lämnas_till_kund;

    @FXML
    private Button gå_till_nästa_steg;

    @FXML
    private Label Skriv_adress;

    @FXML
    private Label dag;

    @FXML
    private Button bekräfta_tid;

    @FXML
    private Button Tillbaka;

    @FXML
    private Button fortsätt_till_betalning;
    @FXML
    private Label kortägare;

    @FXML
    private Label gilltighets_datum;

    @FXML
    private Label cvv_kod;

    @FXML
    private RadioButton kort;

    @FXML
    private RadioButton faktura;

    @FXML
    private RadioButton swish;

    @FXML
    private Label total_summa;

    @FXML
    private Button bekräfta_köp;
    @FXML
    private Button tömmVarukorgButton;

    @FXML
    private Button fortsätt_till_kassan;

    @FXML
    private Button fortsätt_handla;
    @FXML
    private Button ordrarButton;


    private Model model = Model.getInstance();
    @FXML
    private Button tillbaka_varukorg_button;
    @FXML
    private Button varukorg_button;
    @FXML
    private TextField searchField;
    @FXML
    private ListView shoppingCart;

    @FXML
    private Button back_to_peresonUppgifter;
    @FXML
    private Button back_to_leverans;
    @FXML
    private Button updateButton;
    @FXML
    private AnchorPane SparaUppgifter;
    @FXML
            private AnchorPane tack_meddelande;



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
    public void fortsätt_till_kassan_button_press() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("personuppgifter.fxml"));
        Stage window = (Stage) fortsätt_till_kassan.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }
    public void fortsätt_till_leverans_button_press() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Leveranstid.fxml"));
        Stage window = (Stage) gå_till_nästa_steg.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }
    public void fortsätt_till_betalning_button_press() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Betalning.fxml"));
        Stage window = (Stage) fortsätt_till_betalning.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }
    public void fortsätt_handla_button_press() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("imat_app.fxml"));
        Stage window = (Stage) fortsätt_handla.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }
    public void tillbaka_button_press() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("varukorg_app.fxml"));
        Stage window = (Stage) tillbaka.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }
    public void tillbaka_prsonuppgifter_button_press() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("personuppgifter.fxml"));
        Stage window = (Stage) back_to_peresonUppgifter.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }
    public void tillbaka_leverans_button_press() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Leveranstid.fxml"));
        Stage window = (Stage) back_to_leverans.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }
    public void handleOrdrarAction() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ordrarPane.fxml"));
        Stage window = (Stage) ordrarButton.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
        updateOrderList();
    }

    @FXML
    public void toggleSparaUppgifter(){
        SparaUppgifter.setVisible(!SparaUppgifter.isVisible());
    }
    @FXML
    public void toggletackmedelande(){
        tack_meddelande.setVisible(!tack_meddelande.isVisible());
    }










    public void initialize(URL url, ResourceBundle rb) {

        model.getShoppingCart().addShoppingCartListener(this);

        String iMatDirectory = iMatDataHandler.imatDirectory();

        updateProductList(model.getProducts());

        updateVarukorgList(model.getShoppingCart().getItems());
        updateVarukorgItemList(model.getShoppingCart().getItems());

        updateOrderList();


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
<<<<<<< HEAD

    private void updateKategoriList(ProductCategory[] pd) {

        try {
            kategoriFlowPane.getChildren().clear();
            noGroupButton.setToggleGroup(categoryGroup);
            noGroupButton.getStyleClass().add("radioButtons");
            kategoriFlowPane.getChildren().add(noGroupButton);

            for (ProductCategory category : pd) {

                RadioButton rb = new RadioButton(category.toString());
                rb.setToggleGroup(categoryGroup);
                rb.getStyleClass().add("radioButtons");
                kategoriFlowPane.getChildren().add(rb);
            }
        }
        catch (Exception e) {

        }
    }

=======
>>>>>>> 48d838ec0e44d611b52f65cfc3b124d37c97db69
    public void updateVarukorgList(List<se.chalmers.cse.dat216.project.ShoppingItem> shoppingCartItems) {

        try {

            varukorgFlowPane.getChildren().clear();

            for (se.chalmers.cse.dat216.project.ShoppingItem varukorgVara : shoppingCartItems) {

                varukorgFlowPane.getChildren().add(new VarukorgVara(varukorgVara));

            }
            antalVarorLabel.setText("Totalt antal varor: " + (totalCartItems(shoppingCartItems)));
            kostnadLabel.setText("Total kostnad: " + (model.getShoppingCart().getTotal()) + " kr");
        }
        catch (Exception e) {

        }
    }

<<<<<<< HEAD
    public void updateVarukorgItemList(List<se.chalmers.cse.dat216.project.ShoppingItem> shoppingCartItems) {

        try {
            varukorgItemFlowPane.getChildren().clear();

            for (se.chalmers.cse.dat216.project.ShoppingItem varukorgVara2 : shoppingCartItems) {

                varukorgItemFlowPane.getChildren().add(new VarukorgVara2(varukorgVara2));
            }
        }
        catch (Exception e) {

        }
    }

=======
>>>>>>> 48d838ec0e44d611b52f65cfc3b124d37c97db69
    public void updateOrderList() {
        List<Order> orders = iMatDataHandler.getOrders();
        try {

            ordersFlowPane.getChildren().clear();

            for (Order order : orders) {

                ordersFlowPane.getChildren().add(new OrderPane(order));

            }
        }
        catch (Exception e) {
        }
    }

    public double totalCartItems(List<se.chalmers.cse.dat216.project.ShoppingItem> shoppingCartItems) {
        double total = 0.0;
        for (se.chalmers.cse.dat216.project.ShoppingItem varukorgVara : shoppingCartItems) {
            total += varukorgVara.getAmount();
        }
        return total;

    }

    @FXML
    private void handleSearchAction(ActionEvent event) {

        List<Product> matches = model.findProducts(searchField.getText());
        updateProductList(matches);
        System.out.println("# matching products: " + matches.size());

    }

    @FXML
    private void handleTömmVarukorgAction(ActionEvent event) {
        model.getShoppingCart().clear();
    }
    @FXML
    private void handleBekräftaKöpAction() {
        model.placeOrder();

    }
    @FXML
    private void testAction() {
        updateOrderList();
    }


    @Override
    public void shoppingCartChanged(CartEvent cartEvent) {
        updateVarukorgList(model.getShoppingCart().getItems());

    }

}