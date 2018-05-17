package ru.isu.math.yusov.myfirstapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.isu.math.yusov.myfirstapp.model.Profile;

//import java.net.InetSocketAddress;
//import java.net.Proxy;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/main.fxml"));
        primaryStage.setTitle("ИС Строительная компания \"И так сойдет\"");
        primaryStage.setScene(new Scene(root, 385, 185));
        primaryStage.show();
    }
}
