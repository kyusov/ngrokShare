package ru.isu.math.yusov.myfirstapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class OfficeController {

    @FXML
    private TextArea textAria;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void getInfoBuyer(ActionEvent event) {
        textAria.setText("======== Неоноватотов А.А. =========\n" +
                         "======== ВаськовЪ Е.О. ========\n" +
                         " и т.д. ............................");
    }

    @FXML
    void searchPR(ActionEvent event) {
        alert.setTitle("INFO");
        alert.setHeaderText(null);
        alert.setContentText("Плохо!( Никого не нашли(((");
        alert.showAndWait();
    }

    @FXML
    void getProvider(ActionEvent event) {
        alert.setTitle("INFO");
        alert.setHeaderText(null);
        alert.setContentText("Ищем ищем");
        alert.showAndWait();

    }
}
