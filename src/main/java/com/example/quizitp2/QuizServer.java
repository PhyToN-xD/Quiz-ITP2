package com.example.quizitp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizServer {
  public static void main(String[] args) {

    try {
      final ServerSocket serverSocket = new ServerSocket(5000);
      BufferedReader in;
      PrintWriter out;
      final Scanner sc = new Scanner(System.in);

      while (!serverSocket.isClosed()) {
        Socket clientSocket = serverSocket.accept();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        String username = in.readLine();
        if (ClientHandler.usernameList.contains(username)) {
          out.println("uae");
        } else {
          System.out.println("A new client tried connecting!");
          ClientHandler clientHandler = new ClientHandler(clientSocket, username);
          Thread thread = new Thread(clientHandler);
          thread.start();
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
