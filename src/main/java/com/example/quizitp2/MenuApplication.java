package com.example.quizitp2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class MenuApplication {
  @FXML
  Button btnMenuReady;
  @FXML
  TextField usernameMenu;


  public void onBtnMenu() {
    String username = usernameMenu.getText();

    try {
      Socket clientSocket = new Socket("127.0.0.1", 5000);
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      out.println(username);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
