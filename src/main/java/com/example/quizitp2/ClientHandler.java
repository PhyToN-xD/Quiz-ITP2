package com.example.quizitp2;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable {
  Socket clientSocket;
  String username;

  static List<String> usernameList = new ArrayList<>();

  public ClientHandler(Socket clientSocket, String username) {
    this.clientSocket = clientSocket;
    this.username = username;
  }

  @Override
  public void run() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      Thread receaveNames = new Thread(()->{
        try {
            while (clientSocket.isConnected()) {
              System.out.println(username + " | has connected | " + clientSocket.getInetAddress());
              out.println("connected");
              usernameList.add(username);
              username = in.readLine();
            }
        } catch (IOException e) {
          closeEverything(clientSocket, in, out);
        }
      });
      receaveNames.start();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void removeClientHandler() {
    usernameList.remove(username);
    System.out.println(username + " | disconnected");
  }

  public void closeEverything(Socket socket, BufferedReader in, PrintWriter out) {
    removeClientHandler();
    try {
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
      if (socket != null) {
        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
