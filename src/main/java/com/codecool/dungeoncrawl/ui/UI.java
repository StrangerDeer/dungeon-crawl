package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.enemies.Enemy;
import com.codecool.dungeoncrawl.data.actors.spells.ChickenSpell;
import com.codecool.dungeoncrawl.data.actors.spells.Spell;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Set;

public class UI {
    private Canvas canvas;
    private GraphicsContext context;
    private MainStage mainStage;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;

    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
    }

    public void setUpPain(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap());
        }
        enemiesMoves();
        spellsMove();
        refresh();
    }

    private void enemiesMoves(){

        for (Enemy enemy : logic.getMap().getEnemies()){
            if(enemy.getTileName().equals("skeleton")){
                enemy.moveEnemy();
            }else if(enemy.getTileName().equals("giant")){
                enemy.moveEnemy();
            } else if (enemy.getTileName().equals("wizard")) {
                enemy.moveEnemy();
            } else if (enemy.getTileName().equals("chicken")) {
                enemy.moveEnemy();
            }
        }
    }

    private void spellsMove(){


            if (logic.getMap().getSpells().size() > 0) {
                for (Spell spell : logic.getMap().getSpells()) {
                    spell.moveEnemy();
                }
            }

    }

    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < logic.getMapWidth(); x++) {
            for (int y = 0; y < logic.getMapHeight(); y++) {
                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        mainStage.setHealthLabelText(logic.getPlayerHealth());
        mainStage.setAttackStrengthLabelText(logic.getPlayerAttackStrength());
        mainStage.setInventoryContentsText(logic.getPlayerItems());
        mainStage.setEndGameLabelText(Integer.parseInt(logic.getPlayerHealth()), Integer.parseInt(logic.getChickenHealth()));
    }
}
