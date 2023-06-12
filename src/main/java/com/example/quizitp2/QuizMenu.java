package com.example.quizitp2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import java.io.IOException;

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


    primaryStage.setScene(scene);
    primaryStage.show();

    primaryStage.centerOnScreen();
    oldStage = primaryStage;

    //scene.setOnKeyPressed( e -> keyPressed(e) );
  }

  /*private static void keyPressed(KeyEvent e) {
    KeyCode key = e.getCode();
    String keyInput = key.name();
    if (keyInput.matches("[a-zA-Z]")) {
      //Buchstaben an Hangman weitergeben
      System.out.println("Key Pressed: " + keyInput.toLowerCase());
      if (quizController != null) {
        quizController.onInput(keyInput.toLowerCase());
      }
    }
  }
*/
  public static void main(String[] args) {
    launch();
  }
}
