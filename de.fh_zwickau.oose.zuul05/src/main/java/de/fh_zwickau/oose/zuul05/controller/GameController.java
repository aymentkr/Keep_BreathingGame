package de.fh_zwickau.oose.zuul05.controller;

import de.fh_zwickau.oose.zuul05.model.Commands.Command;
import de.fh_zwickau.oose.zuul05.model.Commands.CommandWords;
import de.fh_zwickau.oose.zuul05.model.Game;
import de.fh_zwickau.oose.zuul05.utils.FxUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public Region content;
    public Game game;
    public CommandWords commandWords;
    @FXML
    private Button sleep,help,back,info,quit,use;
    @FXML
    private MenuButton go;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //FxUtil.setBackground(content,"image1.png");
        game = new Game();
        commandWords = new CommandWords();
    }

    @FXML
    public void handleSleepButtonClick() {
        Command command = commandWords.get("schlafen");
        command.execute(game.getPlayer());
    }
    @FXML
    public void handleInfoButtonClick() {
        Command command = commandWords.get("info");
        command.execute(game.getPlayer());
    }
    @FXML
    public void handleHelpButtonClick() {
        Command command = commandWords.get("hilfe");
        command.execute(game.getPlayer());
    }
    @FXML
    public void handleQuitButtonClick(ActionEvent actionEvent) throws IOException {
        FxUtil.hideAndShow(actionEvent,"menu.fxml");
    }

}
