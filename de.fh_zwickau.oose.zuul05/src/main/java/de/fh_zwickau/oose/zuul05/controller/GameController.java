package de.fh_zwickau.oose.zuul05.controller;

import de.fh_zwickau.oose.zuul05.model.Commands.Command;
import de.fh_zwickau.oose.zuul05.model.Commands.CommandWords;
import de.fh_zwickau.oose.zuul05.model.Game;
import de.fh_zwickau.oose.zuul05.utils.FxUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Game controller.
 */
public class GameController implements Initializable {
    public Region content;
    public Game game;
    public CommandWords commandWords;
    @FXML
    public Label day, health, place,items;
    @FXML
    private Button sleep,help,back,info,quit,use,reset;
    @FXML
    private MenuButton go;
    private static boolean endtest = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game();
        commandWords = new CommandWords();
        showLabels();
    }

    /**
     * Show labels.
     */
    public void showLabels (){
        day.setText("Tag: "+game.getPlayer().getCurrentDay());
        health.setText(game.getPlayer().getHealth()+" %");
        place.setText(game.getPlayer().getCurrentRoom().getShortDescription());
        items.setText(game.getPlayer().getCurrentRoom().infoItems());
    }

    /**
     * Handle sleep button click.
     */
    @FXML
    public void handleSleepButtonClick(ActionEvent actionEvent) throws IOException {
        Command command = commandWords.get("schlafen");
        command.execute(game.getPlayer());
        // check if the player still alive
        if (game.getPlayer().getHealth() <= 0) {
            MainController.EndScene(actionEvent);
        } else if (game.getPlayer().getCurrentDay() == 7) {
            endtest = true;
            // teh game ends when the number of days has passed 7
            MainController.EndScene(actionEvent);
        } else showLabels();
    }
    public Boolean getEndTest(){
        return endtest;
    }

    /**
     * Handle info button click.
     */
    @FXML
    public void handleInfoButtonClick() {
        Command command = commandWords.get("info");
        command.execute(game.getPlayer());
    }

    /**
     * Handle help button click.
     */
    @FXML
    public void handleHelpButtonClick() {
        Command command = commandWords.get("hilfe");
        command.execute(game.getPlayer());
    }

    /**
     * Handle quit button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void handleQuitButtonClick(ActionEvent actionEvent) throws IOException {
        FxUtil.hideAndShow(actionEvent,"menu.fxml");
    }

    /**
     * Handle go button click.
     *
     * @param actionEvent the action event
     */
    @FXML
    public void handleGoButtonClick(ActionEvent actionEvent) {
        String choice = ((MenuItem)actionEvent.getSource()).getText();
        game.getPlayer().walk(choice.toLowerCase());
        FxUtil.updateBackground(game.getPlayer(),content);
        showLabels();
    }

    @FXML
    public void handleBackButtonClick(){
        Command command = commandWords.get("zurueck");
        command.execute(game.getPlayer());
        FxUtil.updateBackground(game.getPlayer(),content);
        showLabels();
    }

    @FXML
    public void handleUseButtonClick(){
        Command command = commandWords.get("benutze");
        command.execute(game.getPlayer());
        showLabels();
    }

    @FXML
    public void handleResetButtonClick(){
        game = new Game();
        commandWords = new CommandWords();
        showLabels();
        FxUtil.updateBackground(game.getPlayer(),content);
    }

}
