package de.fh_zwickau.oose.zuul05.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class EndController extends GameController implements Initializable {
    @FXML
    public Label endtext;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (getEndTest())
            endtext.setText("Wohoo! Du hast gewonnen");
        else endtext.setText("Sorry! Du hast leider verloren :(");
    }
}
