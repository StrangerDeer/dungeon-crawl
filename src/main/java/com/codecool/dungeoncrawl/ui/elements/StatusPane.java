package com.codecool.dungeoncrawl.ui.elements;

import com.codecool.dungeoncrawl.data.items.Item;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static javafx.scene.text.Font.getFontNames;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 270;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label attackStrengthTextLabel;
    private Label attackStrengthValueLabel;
    private Label inventoryLabel;
    private Label inventoryContents;
    private final double MAX_FONT_SIZE = 22.0;

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        healthTextLabel.setFont(Font.font("Cambria", FontWeight.BOLD, MAX_FONT_SIZE));
        healthTextLabel.setTextFill(Color.color(0.84, 0.81, 0.76));
        healthTextLabel.setMinHeight(25);

        healthValueLabel = new Label();
        healthValueLabel.setTextFill(Color.color(0.858, 0.03, 0.38));
        healthValueLabel.setFont(new Font(MAX_FONT_SIZE));

        attackStrengthTextLabel = new Label("Attack strength: ");
        attackStrengthTextLabel.setFont(Font.font("Cambria", FontWeight.BOLD, MAX_FONT_SIZE));
        attackStrengthTextLabel.setTextFill(Color.color(0.84, 0.81, 0.76));
        attackStrengthTextLabel.setMinHeight(30);

        attackStrengthValueLabel = new Label();
        attackStrengthValueLabel.setTextFill(Color.color(0.9, 0.4, 0));
        attackStrengthValueLabel.setFont(new Font(MAX_FONT_SIZE));

        inventoryLabel = new Label("Inventory: ");
        inventoryLabel.setFont(Font.font("Cambria", FontWeight.BOLD, MAX_FONT_SIZE));
        inventoryLabel.setMinHeight(30);
        inventoryLabel.setTextFill(Color.color(0.84, 0.81, 0.76));

        inventoryContents = new Label();
        inventoryContents.setTextFill(Color.color(0.84, 0.81, 0.76));
        inventoryContents.setFont(Font.font("Cambria", FontWeight.SEMI_BOLD, MAX_FONT_SIZE));
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 0, 1);

        ui.add(attackStrengthTextLabel, 0, 2);
        ui.add(attackStrengthValueLabel, 0, 3);

        ui.add(inventoryLabel, 0, 4);
        ui.add(inventoryContents,  0, 5);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        borderPane.setBackground(new Background(new BackgroundFill(Color.color(0.208, 0.1, 0.16), CornerRadii.EMPTY, Insets.EMPTY)));
        return borderPane;
    }

    public void setHealthValue(String text) {
        String hearts = new String(new char[Integer.parseInt(text)]).replace("\0", "♥");
        healthValueLabel.setText(hearts);

    }

    public void setAttackStrengthValue(String text) {
        String swords = new String(new char[Integer.parseInt(text)]).replace("\0", "\uD83D\uDDE1");
        attackStrengthValueLabel.setText(swords);
    }

    public void setInventoryContents(List<Item> items) {
        List<String> itemList = new ArrayList<>();
        for (Item item : items) {
            itemList.add(" - " + item.getTileName());
        }
        inventoryContents.setText(itemList.stream()
                .collect(joining(",\n")));
    }
}
