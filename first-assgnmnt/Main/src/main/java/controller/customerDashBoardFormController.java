package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class customerDashBoardFormController {
    public JFXButton btnAdd;
    public JFXButton btnSearch;

    public void btnAddOnClick(ActionEvent actionEvent) {
        Stage stage= new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/add_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void btnSearchOnClick(ActionEvent actionEvent) {
        Stage stage= new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/search_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }
}
