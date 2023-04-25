package com.codecool.dungeoncrawl.ui.elements;

import com.codecool.dungeoncrawl.data.items.Item;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 270;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label emptyLine;
    private Label inventoryLabel;
    private Label inventoryContents;
    private final double MAX_FONT_SIZE = 22.0;

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        healthTextLabel.setFont(new Font(MAX_FONT_SIZE));
        healthValueLabel = new Label();
        healthValueLabel.setTextFill(Color.color(1, 0, 0));
        healthValueLabel.setFont(new Font(MAX_FONT_SIZE));
        emptyLine = new Label("   ");
        inventoryLabel = new Label("Inventory: ");
        inventoryLabel.setFont(new Font(MAX_FONT_SIZE));
        inventoryContents = new Label();
        inventoryContents.setFont(new Font(MAX_FONT_SIZE));
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 0, 1);
        ui.add(emptyLine, 1, 2);
        ui.add(inventoryLabel, 0, 3);
        ui.add(inventoryContents,  0, 4);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        String hearts = new String(new char[Integer.parseInt(text)]).replace("\0", "♥");
        healthValueLabel.setText(hearts);

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
