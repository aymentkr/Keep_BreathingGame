package de.fh_zwickau.oose.zuul05.controller;

import de.fh_zwickau.oose.zuul05.utils.FxUtil;
import javafx.fxml.Initializable;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public Region content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FxUtil.setBackground(content,"image1.png");
    }


}
