package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class addCustomerFormController implements Initializable {

    @FXML
    public Label lblError;
    @FXML
    public DatePicker pickDate;
    @FXML
    private JFXButton btnAdd;
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

    @FXML
    void btnAddOnClick(ActionEvent event) {
        boolean b= checkCusId();
        if(b==false){
            System.out.println("Duplicate ID");
            lblError.setText("Existing ID , Can't add again ");
            clearForm();
        }else {
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String contact = txtContact.getText();
            String title = comboTitle.getValue();
            LocalDate date = pickDate.getValue();

            Customer customer = new Customer(id,name,address,contact,title,date);
            System.out.println(customer);


            customerList.add(customer);
            System.out.println(customerList);

            clearForm();
            lblError.setText(null);
        }

    }


    public boolean checkCusId(){
        String stringId=txtId.getText();
        boolean a =true;

        for(Customer cus:customerList){
            if(stringId.equals(cus.getId())){
                a=false;
            }
        }return a;

    }



    public void clearForm(){
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtContact.setText(null);
        comboTitle.setValue(null);
        pickDate.setValue(null);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("MR:");
        titles.add("Miss:");
        titles.add("Dr:");
        titles.add("Prof:");

        comboTitle.setItems(titles);
    }
}
