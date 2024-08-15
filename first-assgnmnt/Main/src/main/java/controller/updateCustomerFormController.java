package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Customer;

import java.util.List;

public class updateCustomerFormController {
//    private int index;
//
//    public updateCustomerFormController(int index){
//        this.index=index;
//    }

    @FXML
    private JFXButton btnDone;

    @FXML
    private JFXTextField updateAddress;

    @FXML
    private JFXTextField updateContact;

    @FXML
    private JFXTextField updateName;

    List<Customer> customerList = DBConnection.getInstance().getCustomerList();
//
//    @FXML
//    void btnDoneOnClick(ActionEvent event) {
//        updateCustomer();
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//          alert.setHeaderText(null);
//          alert.setContentText("...Successfully updated...");
//          alert.show();
//
//    }
//
//    public void updateCustomer(){
//        Customer cus = customerList.get(index);
//
//        cus.setName(updateName.getText());
//        cus.setAddress(updateAddress.getText());
//        cus.setContact(updateContact.getText());
//
//        System.out.println(customerList);
//    }
}
