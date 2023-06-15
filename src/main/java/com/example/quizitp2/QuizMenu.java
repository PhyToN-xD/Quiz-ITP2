package com.example.quizitp2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.media.Media;

public class QuizMenu extends Application {
  static Stage oldStage;
  static Quiz quizController = new Quiz();

  @Override
  public void start(Stage primaryStage) throws IOException {

    //menu.fxml gehört eingefügt
    FXMLLoader loader = new FXMLLoader(QuizMenu.class.getResource("menu.fxml"));

    Parent root = loader.load();

    primaryStage.setTitle("Menu");
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();

    oldStage = primaryStage;
  }

  public static void ChangeScenes(String fxml, String GameName) throws IOException {
    FXMLLoader loader = new FXMLLoader(QuizMenu.class.getResource(fxml));
    Parent root = loader.load();
    quizController = loader.getController();
    oldStage.close();
    Scene scene = new Scene(root);
    Stage primaryStage = new Stage();
    primaryStage.setTitle(GameName);

    primaryStage.setScene(scene);
    primaryStage.show();

    primaryStage.centerOnScreen();
    oldStage = primaryStage;
  }

  public static void main(String[] args) {
    launch();
  }
}
