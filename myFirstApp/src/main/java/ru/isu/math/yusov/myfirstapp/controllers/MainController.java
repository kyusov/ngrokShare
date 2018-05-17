package ru.isu.math.yusov.myfirstapp.controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {

    @FXML
    private RadioButton radio3, radio5, radio2, radio1, radio4, radio6;


    @FXML
    void buttonInClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/profile.fxml"));
        stage.setTitle("Выбор профиля");
        stage.setScene(new Scene(root, 251, 238));
        stage.show();

    }


    @FXML
    void buttonSelect(ActionEvent event) throws IOException {
        switch (radioClick(event)) {
            case 1:
                Stage stage1 = new Stage();
                Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("views/profileBooker.fxml"));
                stage1.setTitle("Бухгалтерия");
                stage1.setScene(new Scene(root1, 640, 396));
                stage1.show();
                break;
            case 2:
                Stage stage2 = new Stage();
                Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource("views/profileHRD.fxml"));
                stage2.setTitle("Отдел кадров");
                stage2.setScene(new Scene(root2, 500, 391));
                stage2.show();
                break;
            case 3:
                Stage stage3 = new Stage();
                Parent root3 = FXMLLoader.load(getClass().getClassLoader().getResource("views/profileProvider.fxml"));
                stage3.setTitle("Поставщик");
                stage3.setScene(new Scene(root3, 640, 311));
                stage3.show();
                break;
            case 4:
                Stage stage4 = new Stage();
                Parent root4 = FXMLLoader.load(getClass().getClassLoader().getResource("views/profileBuyer.fxml"));
                stage4.setTitle("Покупатель");
                stage4.setScene(new Scene(root4, 640, 400));
                stage4.show();
                break;
            case 5:
                Stage stage5 = new Stage();
                Parent root5 = FXMLLoader.load(getClass().getClassLoader().getResource("views/profileOffice.fxml"));
                stage5.setTitle("Сотрудник главного офиса");
                stage5.setScene(new Scene(root5, 267, 436));
                stage5.show();
                break;
            case 6:
                Stage stage6 = new Stage();
                Parent root6 = FXMLLoader.load(getClass().getClassLoader().getResource("views/Rest.fxml"));
                stage6.setTitle("ControllerRest");
                stage6.setScene(new Scene(root6, 267, 436));
                stage6.show();
                break;
        }
    }

    @FXML
    private int radioClick(ActionEvent event) {
        int i = 0;

        if (radio1.isSelected()) {
            i = 1;
        }
        if (radio2.isSelected()) {
            i = 2;
        }
        if (radio3.isSelected()) {
            i = 3;
        }
        if (radio4.isSelected()) {
            i = 4;
        }
        if (radio5.isSelected()) {
            i = 5;
        }
        if (radio6.isSelected()) {
            i = 6;
        }

        return i;
    }

}
