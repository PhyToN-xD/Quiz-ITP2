package com.example.quizitp2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Quiz {
  private String filePath = "src/json/package.json";

  public void openJson() throws IOException {
    File file = new File(filePath);
    String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
    JSONObject obj = new JSONObject(content);
    JSONArray questionArray = obj.getJSONArray("questions");
    for (int i = 0; i < questionArray.length(); i++) {
      System.out.println(questionArray.getJSONObject(i).get("id"));
      System.out.println(questionArray.getJSONObject(i).get("frage"));
    }

  }

  public void onInput(String letter) {

  }
}
