package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.util.List;

public class searchCustomerFormController {

    @FXML
    public JFXTextField txtSearch;
    @FXML
    public JFXButton btnSearch;
    @FXML
    public Label txtShowResult;
    @FXML
    public DatePicker pickDate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXComboBox<String> comboTitle;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtName;

    List<Customer> customerList = DBConnection.getInstance().getCustomerList();

    public int index;



    @FXML
    void btnDeleteOnClick(ActionEvent event) {

        System.out.println(index);
        Customer cus= customerList.get(index);
        cus.setName(null);
        cus.setId(null);
        cus.setAddress(null);
        cus.setContact(null);
        cus.setDate(null);
        cus.setTitle(null);

        customerList.remove(index);

        System.out.println(customerList);

        clearForm();

    }

    @FXML
    void btnUpdateOnClick(ActionEvent event) {



//        Stage stage=new Stage();
//        try {
//            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/update_customer.fxml"))));
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        stage.show();


//        updateCustomerFormController controller = new updateCustomerFormController(index);
//        controller.updateCustomer();



      Customer cus = customerList.get(index);

      cus.setName(txtName.getText());
      cus.setAddress(txtAddress.getText());
      cus.setContact(txtContact.getText());

      System.out.println(customerList);

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setContentText("...Updated Successfully...");
      alert.show();

      clearForm();

    }


    @FXML
    public void btnSearch(ActionEvent actionEvent) {
        // to clear the error msg before search another id
        txtShowResult.setText("");

        String inputStringId = txtSearch.getText();
        for(Customer cus: customerList) {
            if(inputStringId.equals(cus.getId())){

                index= customerList.indexOf(cus);
                System.out.println(index);

                txtId.setText(cus.getId());
                txtName.setText(cus.getName());
                txtAddress.setText(cus.getAddress());
                txtContact.setText(cus.getContact());
                comboTitle.setValue(cus.getTitle());
                pickDate.setValue(cus.getDate());

                txtSearch.setText(null);

                comboTitle.setEditable(false);
                pickDate.setEditable(false);

            }else {
                System.out.println("new");
                txtShowResult.setText("New Customer");
                clearForm();
            }
        }

    }

    public void clearForm(){
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtContact.setText(null);
        comboTitle.setValue(null);
        pickDate.setValue(null);

    }


}
