package ru.isu.math.yusov.myfirstapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class BuyerController {

    @FXML
    private ImageView imgKvart;
    @FXML
    private TextArea textAria;

    @FXML
    void btnGetInfoKvart(ActionEvent event) {
        Image img = new Image(getClass().getClassLoader().getResourceAsStream("heh.jpg"));
        imgKvart.setImage(img);
        textAria.setText("Этаж:                                                         6\n"+
                         "Цена:                                                10.000\n"+
                         "Информация о застройщике:                                    \n"+
                         "ОАО И ТАК СОЙДЕТ\n"+
                         "Сделаем быстро и \"качественно\"          \n"+
                         "Вот так вот");
    }


}
