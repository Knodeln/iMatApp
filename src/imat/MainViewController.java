
package imat;

import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.scene.traversal.ParentTraversalEngine;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private TextField förnamn;
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
    private DatePicker leveransDatumDatePicker;

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
    @FXML
    private Button tillbaka_varukorg_button1;

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
    @FXML
    private FlowPane kategoriFlowPane;
    @FXML
    private final ToggleGroup categoryGroup = new ToggleGroup();
    private RadioButton noGroupButton = new RadioButton("NO CATEGORY");
    @FXML
    private FlowPane varukorgItemFlowPane;
    @FXML
    private FlowPane productFlowPane;
    @FXML
    private TextField efternamnTextField;
    @FXML
    private TextField adressTextField;
    @FXML
    private TextField postnummerTextField;
    @FXML
    private TextField postAdressTextField;
    @FXML
    private TextField epostadressTextFeild;
    @FXML
    private TextField telefonnummerTextField;
    @FXML
    private TextField personnummerTextField;
    @FXML
    private ComboBox leveransTider;
    private LocalDate leveransdatum;
    @FXML
    private ComboBox betalningComboBox;
    @FXML
    private ComboBox monthCombo;
    @FXML
    private ComboBox yearCombo;
    @FXML
    private TextField numberTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField cvcField;
    @FXML
    private Label betalningKostnad;
    @FXML
    private Label betalningVaror;
    @FXML
    private Label antalOrdrarLabel;


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
        updatePersonuppgifter();
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
        updatePersonuppgifter();
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
        updateCreditCard();
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

    public void initialize(URL url, ResourceBundle rb) {

        model.getShoppingCart().addShoppingCartListener(this);

        String iMatDirectory = iMatDataHandler.imatDirectory();

        updateProductList(model.getProducts());
        updateVarukorgList(model.getShoppingCart().getItems());
        updateVarukorgItemList(model.getShoppingCart().getItems());
        updateKategoriList(ProductCategory.values());
        updateOrderList();
        updatePersonuppgifterPanel();
        updateLeveransPanel();
        updateBetalningPanel();

        categoryGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)categoryGroup.getSelectedToggle();

                if (rb != null) {
                    if(rb.getText() != "NO CATEGORY"){
                        updateProductList(model.getProducts(ProductCategory.valueOf(rb.getText())));
                    }else{
                        updateProductList(model.getProducts());
                    }
                }
            };
        });

    }

    private void updateProductList(List<Product> products) {

        try {
            System.out.println("updateProductList " + products.size());
            productFlowPane.getChildren().clear();

            for (Product product : products) {

                productFlowPane.getChildren().add(new Vara(product));
            }
        }
        catch (Exception e) {

        }
    }

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
    public void updateVarukorgItemList(List<se.chalmers.cse.dat216.project.ShoppingItem> shoppingCartItems) {

        try {
            varukorgItemFlowPane.getChildren().clear();

            for (se.chalmers.cse.dat216.project.ShoppingItem varukorgVara2 : shoppingCartItems) {

                varukorgItemFlowPane.getChildren().add(new VarukorgVara2(varukorgVara2));
            }
            String text = "Varukorg: " + iMatDataHandler.getShoppingCart().getTotal();
            text += " kr";
            varukorg_button.setText(text);
        }
        catch (Exception e) {

        }
    }
    public void updateOrderList() {
        List<Order> orders = iMatDataHandler.getOrders();
        try {

            ordersFlowPane.getChildren().clear();

            for (Order order : orders) {

                ordersFlowPane.getChildren().add(new OrderPane(order));

            }
            antalOrdrarLabel.setText("Antal ordrar: " + iMatDataHandler.getOrders().size());
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
        updateCreditCard();
        tack_meddelande.toFront();


    }
    @FXML
    private void testAction() {
        updateOrderList();
    }


    @Override
    public void shoppingCartChanged(CartEvent cartEvent) {
        updateVarukorgList(model.getShoppingCart().getItems());
        updateVarukorgItemList(model.getShoppingCart().getItems());

    }
    private void updatePersonuppgifter() {
        Customer customer = iMatDataHandler.getCustomer();
        customer.setFirstName(förnamn.getText());
        customer.setLastName(efternamnTextField.getText());
        customer.setAddress(adressTextField.getText());
        customer.setPostCode(postnummerTextField.getText());
        customer.setPostAddress(postAdressTextField.getText());
        customer.setEmail(epostadressTextFeild.getText());
        customer.setPhoneNumber(telefonnummerTextField.getText());
        customer.setMobilePhoneNumber(personnummerTextField.getText());


    }

    private void updatePersonuppgifterPanel() {
        try {
            Customer customer = iMatDataHandler.getCustomer();
            förnamn.setText(customer.getFirstName());
            efternamnTextField.setText(customer.getLastName());
            adressTextField.setText(customer.getAddress());
            postnummerTextField.setText(customer.getPostCode());
            postAdressTextField.setText(customer.getPostAddress());
            epostadressTextFeild.setText(customer.getEmail());
            telefonnummer.setText(customer.getPhoneNumber());
            personnummer.setText(customer.getMobilePhoneNumber());

        }
        catch (Exception e){

        }
    }
    @FXML
    private void updateLeverans() {
        leveransdatum = leveransDatumDatePicker.getValue();

    }
    private void updateLeveransPanel() {

        try {
            leveransDatumDatePicker.setValue(leveransdatum);
            leveransTider.getItems().addAll(model.getleveransTider());

        }
        catch (Exception e) {

        }

    }
    private void updateBetalningPanel() {

        try {
            betalningComboBox.getItems().addAll(model.getCardTypes());

            monthCombo.getItems().addAll(model.getMonths());

            yearCombo.getItems().addAll(model.getYears());
            CreditCard card = model.getCreditCard();
            numberTextField.setText(card.getCardNumber());
            nameTextField.setText(card.getHoldersName());
            betalningComboBox.getSelectionModel().select(card.getCardType());
            monthCombo.getSelectionModel().select(""+card.getValidMonth());
            yearCombo.getSelectionModel().select(""+card.getValidYear());

            cvcField.setText(""+card.getVerificationCode());

            betalningVaror.setText("" + (totalCartItems(model.getShoppingCart().getItems())));
            betalningKostnad.setText((model.getShoppingCart().getTotal()) + " kr");

        }
        catch (Exception e) {

        }

    }
    private void updateCreditCard() {

        CreditCard card = model.getCreditCard();

        card.setCardNumber(numberTextField.getText());
        card.setHoldersName(nameTextField.getText());

        String selectedValue = (String) betalningComboBox.getSelectionModel().getSelectedItem();
        card.setCardType(selectedValue);

        selectedValue = (String) monthCombo.getSelectionModel().getSelectedItem();
        card.setValidMonth(Integer.parseInt(selectedValue));

        selectedValue = (String) yearCombo.getSelectionModel().getSelectedItem();
        card.setValidYear(Integer.parseInt(selectedValue));

        card.setVerificationCode(Integer.parseInt(cvcField.getText()));

    }

}