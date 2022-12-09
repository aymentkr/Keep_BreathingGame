package de.fh_zwickau.oose.zuul05.utils;

import de.fh_zwickau.oose.zuul05.MainApplication;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.Objects;

public class FxUtil {
    public static Stage getCurrentStage(ActionEvent event){
        Node node = (Node) event.getSource();
        return (Stage) node.getScene().getWindow();
    }

    public static void setBackground(Region region, String url) {
        region.setStyle("-fx-background-image: url("+ Objects.requireNonNull(MainApplication.class.getResource(url)) +");");
    }
}
