package de.fh_zwickau.oose.zuul05.utils;

import de.fh_zwickau.oose.zuul05.MainApplication;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class FxUtil {
    public static Stage getCurrentStage(ActionEvent event){
        Node node = (Node) event.getSource();
        return (Stage) node.getScene().getWindow();
    }

    public static void loadImage(ImageView imageView, String url){
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(Objects.requireNonNull(MainApplication.class.getResource(url)).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imageView.setImage(image);
    }
}
