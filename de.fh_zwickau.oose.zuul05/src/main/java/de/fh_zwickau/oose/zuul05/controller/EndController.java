package de.fh_zwickau.oose.zuul05.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EndController {
    @FXML
    public Label textlabel;

    @FXML
    public void setText(String text) {
        textlabel.setText(text);
    }
}
