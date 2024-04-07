module com.example.sampleguiproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;

    requires com.jfoenix;


    opens com.example.sampleguiproject to javafx.fxml;
    exports com.example.sampleguiproject;
}