package de.fh_zwickau.oose.zuul05.controller;

import de.fh_zwickau.oose.zuul05.utils.FxUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainController {
    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }
    @FXML
    public void onStartButtonClick(ActionEvent actionEvent) throws IOException {
        FxUtil.hideAndShow(actionEvent,"GameScene.fxml");
    }

    @FXML
    public static void EndScene(ActionEvent actionEvent,String text) throws IOException {
        FxUtil.hideAndShow(actionEvent,"EndScene.fxml");
        EndController ending = new EndController();
        ending.setText(text);
    }
}