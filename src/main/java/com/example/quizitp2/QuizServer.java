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

      try {
        while (!serverSocket.isClosed()) {
          Socket clientSocket = serverSocket.accept();
          System.out.println("A new client connected!");
          ClientHandler clientHandler = new ClientHandler(clientSocket);
          Thread thread = new Thread(clientHandler);
          thread.start();
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
