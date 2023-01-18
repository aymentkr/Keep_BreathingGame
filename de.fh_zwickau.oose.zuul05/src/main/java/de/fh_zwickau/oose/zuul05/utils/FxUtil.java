package de.fh_zwickau.oose.zuul05.utils;

import de.fh_zwickau.oose.zuul05.MainApplication;
import de.fh_zwickau.oose.zuul05.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FxUtil {
    public static Stage getCurrentStage(ActionEvent event){
        Node node = (Node) event.getSource();
        return (Stage) node.getScene().getWindow();
    }

    public static void setBackground(Region region, String url) {
        region.setStyle("-fx-background-image: url("+ Objects.requireNonNull(MainApplication.class.getResource(url)) +");");
    }
    public static void updateBackground(Player player, Region content) {
        switch (player.getCurrentRoom().getShortDescription()) {
            case "im Ruheraum" -> setBackground(content, "image1.png");
            case "in der Schiff Oberfläche" -> setBackground(content, "image2.png");
            case "Platz der Kategorie Getränke" -> setBackground(content, "drink.png");
            case "Platz der Kategorie Essen" -> setBackground(content, "food.png");
            case "Platz der Kategorie Obst" -> setBackground(content, "fruit.png");
        }
    }
    public static void hideAndShow(ActionEvent actionEvent, String url) throws IOException {
        Stage stage = FxUtil.getCurrentStage(actionEvent);
        stage.hide();
        FXMLLoader fxmlLoader= MainApplication.getLoader(url);
        Scene startScene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setScene(startScene);
        stage.show();
        stage.centerOnScreen();
        stage.setMaximized(true);
        //stage.setFullScreen(true);
    }


}
