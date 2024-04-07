package com.example.sampleguiproject;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class RowRecord extends Row{

    public Button delBTN = new Button("Delete");

    public RowRecord(String processName, int arrivalTime, int burstTime) {
        // super is for using the constructor of extended file
        super(processName, arrivalTime, burstTime);
        btnDecoration();
    }

    public Button getDelBTN() {
        return delBTN;
    }

    public void setDelBTN(Button delBTN) {
        this.delBTN = delBTN;
    }

    public final void btnDecoration() {
        delBTN.setStyle("-fx-background-color:#DAB88B");
        delBTN.setCursor(Cursor.HAND);
    }
}
