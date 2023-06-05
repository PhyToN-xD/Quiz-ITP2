module com.example.quizitp2 {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.quizitp2 to javafx.fxml;
  exports com.example.quizitp2;
}