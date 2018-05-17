package ru.isu.math.yusov.myfirstapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class ProviderController {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void addReestr(ActionEvent event) {
        alert.setTitle("INFO");
        alert.setHeaderText(null);
        alert.setContentText("Отлично! Вы записаны в реестр!");
        alert.showAndWait();
    }
}
