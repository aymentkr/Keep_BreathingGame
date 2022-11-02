package de.fh_zwickau.oose.zuul05.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {
    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }

    public void onStartButtonClick(ActionEvent actionEvent) {
    }
}