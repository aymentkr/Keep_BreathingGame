package de.fh_zwickau.oose.zuul05.controller;

import de.fh_zwickau.oose.zuul05.MainApplication;
import de.fh_zwickau.oose.zuul05.model.Game;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import de.fh_zwickau.oose.zuul05.utils.FxUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class MainController {
    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }
    @FXML
    public void onStartButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = FxUtil.getCurrentStage(actionEvent);
        stage.hide();
        FXMLLoader fxmlLoader= MainApplication.getLoader("GameScene.fxml");
        Scene gameScene = new Scene(fxmlLoader.load(), 555, 471);
        stage.setScene(gameScene);
        stage.show();
        stage.centerOnScreen();
    }
}