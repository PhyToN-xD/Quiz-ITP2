package com.example.quizitp2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class MenuApplication {
  @FXML
  Button btnMenuReady;
  @FXML
  TextField usernameMenu;
  @FXML
  Text text;


  public void onBtnMenu() {
    String username = usernameMenu.getText();

    try {
      Socket clientSocket = new Socket("127.0.0.1", 5000);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      out.println(username);

      try {
        String msg;
        msg = in.readLine();
        if (msg.contains("connected")){

        } else if (msg.contains("username already exists")){
          text.setText("Usernmae already exists");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

    } catch (IOException e) {
      text.setText("Irgendetwas ist Schiefgelaufen");
      e.printStackTrace();
    }
  }
}
