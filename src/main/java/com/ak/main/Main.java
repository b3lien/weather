package com.ak.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        //związanie okna z plikiem fxml gdzie jest zdefiniowany layout
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Główne okno");
        Scene scene = new Scene(root, 300,270);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
    launch(args);
    }
}
