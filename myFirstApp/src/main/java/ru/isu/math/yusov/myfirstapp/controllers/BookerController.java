package ru.isu.math.yusov.myfirstapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BookerController {

    @FXML
    private Label lostCash;

    @FXML
    private Label lostCashAll;

    @FXML
    private void sumLostCash(ActionEvent event) {
        lostCash.setText("101110001001.1");
        lostCashAll.setText("101110001001.1");
    }

}
