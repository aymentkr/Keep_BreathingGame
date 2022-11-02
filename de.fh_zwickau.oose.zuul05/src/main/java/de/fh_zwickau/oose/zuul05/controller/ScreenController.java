package de.fh_zwickau.oose.zuul05.controller;

import de.fh_zwickau.oose.zuul05.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenController {
    @FXML
    Label text;
    @FXML
    private Pane gameView;


    public void setText(String text) {
        this.text.setText(text);
    }

    public void EndScene(String text) {
        Stage thisStage = (Stage) gameView.getScene().getWindow();
        thisStage.hide();
        FXMLLoader loader = MainApplication.getLoader("EndScene.fxml");
        Parent newWindow = null;
        ScreenController controller = null;
        try {
            newWindow = loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert newWindow != null;
        thisStage.setScene(new Scene(newWindow));
        thisStage.centerOnScreen();
        controller.setText(text);
        thisStage.show();
    }
}
