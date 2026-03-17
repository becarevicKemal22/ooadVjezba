package com.example.lv09;

import com.example.lv09.controller.OsobaController;
import com.example.lv09.controller.PredmetController;
import com.example.lv09.model.OsobaModel;
import com.example.lv09.model.PredmetModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // PRVI ZADATAK
//        OsobaModel osobaModel = OsobaModel.getInstance();
//
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        fxmlLoader.setController(new OsobaController(osobaModel));
//
//        Scene scene = new Scene(fxmlLoader.load(), 300, 500);
//        stage.setTitle("Dodaj osobu! SELMAAAA");
//        stage.setScene(scene);
//        stage.show();

        // ZADATAK 2
        PredmetModel predmetModel = PredmetModel.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("predmet-view.fxml"));
        fxmlLoader.setController(new PredmetController(predmetModel));

        Scene scene = new Scene(fxmlLoader.load(), 300, 200);
        stage.setTitle("FORMA NIJE FUNKCIONALNA!");
        stage.setScene(scene);
        stage.show();
    }
}
