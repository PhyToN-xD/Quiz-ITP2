package com.example.quizitp2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class QuizApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) throws IOException {
    Quiz test = new Quiz();
    test.openJson();
    launch();
  }
}