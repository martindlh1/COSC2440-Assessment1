package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class loginController {
    @FXML
    private TextField userID;
    @FXML
    private PasswordField userPassword;
    @FXML
    void loginBtnClicked(ActionEvent event) {
        if (userID != null && userPassword != null) {
            String ID = userID.getText();
            String password = userPassword.getText();

            if(ID.equals("admin") && password.equals("1234")) {
                loadScene(event);
            } else {
                showAlert("Login Failed","Wrong ID or password entered");
            }
        } else {
            System.out.println("entered value is not valid");
        }
    }

    private void loadScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/Main.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
