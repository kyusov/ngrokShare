package ru.isu.math.yusov.myfirstapp.controllers;

import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.isu.math.yusov.myfirstapp.ProfileService;
import ru.isu.math.yusov.myfirstapp.model.Profile;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class ControllerRest {

    @FXML
    ListView list;

    @FXML
    private TextField textValue;


    @FXML
    private Label labelCheck;

    ObservableList content;

    ProfileService profile;

    public void initialize() throws IOException {


        Proxy proxy = new Proxy(Proxy.Type.HTTP,  new InetSocketAddress(
                "proxy.isu.ru", 3128));
        OkHttpClient client = new OkHttpClient.Builder().proxy(proxy).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://7a635c02.ngrok.io")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        profile = retrofit.create(ProfileService.class);
        Response<List<Profile>> res = profile.profile().execute();

        content = FXCollections.observableArrayList(
                res.body()
        );
        list.setItems(content);



        list.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Profile p = (Profile)list.getSelectionModel().getSelectedItem();
                labelCheck.setText( " " + p);
            }
        });
    }

    class ListViewHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            //this method will be overrided in next step
        }
    }




    @FXML
    void addProfile(ActionEvent event) throws IOException {
        Profile p  = profile.addProfile(new Profile(0, textValue.getText())).execute().body();
        content.add(p);
        list.setItems(content);
    }


    @FXML
    void deleteProfile(ActionEvent event) throws IOException {

        Profile p = (Profile)list.getSelectionModel().getSelectedItem();

        profile.deleteProfile(p.getID()).execute();

        content.remove(list.getSelectionModel().getSelectedIndex());
        list.setItems(content);

    }

}
