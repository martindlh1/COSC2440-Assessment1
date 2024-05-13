package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.application.Platform;

public class menuController {

    @FXML
    void addBtnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/add.fxml"));
            Parent root = loader.load();

            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.setTitle("ICM - Add");
            addStage.show();

            Stage currentStage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deleteBtnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/delete.fxml"));
            Parent root = loader.load();

            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.setTitle("ICM - Delete");
            addStage.show();

            Stage currentStage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void updateBtnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/update.fxml"));
            Parent root = loader.load();

            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.setTitle("ICM - Update");
            addStage.show();

            Stage currentStage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void printOneCustomer(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/OneCustomer.fxml"));
            Parent root = loader.load();

            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.setTitle("ICM - Print one customer information");
            addStage.show();

            Stage currentStage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void printAllCustomers(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/allCustomers.fxml"));
            Parent root = loader.load();

            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.setTitle("ICM - Print all customer information");
            addStage.show();

            Stage currentStage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void printOneClaim(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/oneClaim.fxml"));
            Parent root = loader.load();

            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.setTitle("ICM - Print one claim imformation");
            addStage.show();

            Stage currentStage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void printAllClaim(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/allClaims.fxml"));
            Parent root = loader.load();

            Stage addStage = new Stage();
            addStage.setScene(new Scene(root));
            addStage.setTitle("ICM - Print all claim imformation");
            addStage.show();

            Stage currentStage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void saveBtnClicked(ActionEvent event) {
        boolean saveAttempt = true;
        if(saveAttempt) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("File saving");
            alert.setHeaderText(null);
            alert.setContentText("Progress is successfully saved.");
            alert.showAndWait();
        }
    }

    @FXML
    void saveAndExit(ActionEvent event) {
        boolean saveAttempt = true;
        if(saveAttempt) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("File saving");
            alert.setHeaderText(null);
            alert.setContentText("Progress is successfully saved.");
            alert.showAndWait().ifPresent(response -> {
                if(response == ButtonType.OK) {
                    Platform.exit();
                }
            });
        }
    }
}



