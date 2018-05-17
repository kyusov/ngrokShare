package ru.isu.math.yusov.myfirstapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class HRDController {
    //HRD - Human Resources Department
    //Отдел кадров

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private void addMan(ActionEvent event) {
        alert.setTitle("info");
        alert.setHeaderText(null);
        alert.setContentText("Сотрудник принят!");

        alert.showAndWait();

    }

    @FXML
    private void deleteMan(ActionEvent event) {
        alert.setTitle("info");
        alert.setHeaderText(null);
        alert.setContentText("Сотрудник удален!");

        alert.showAndWait();
    }

}
