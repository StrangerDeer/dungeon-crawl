package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    private List<Item> items;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
        this.items = new ArrayList<>();
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType().equals(CellType.FLOOR) && nextCell.getActor() == null) {
            if (nextCell.getItem() != null) {
                System.out.println(nextCell.getItem());
                addItemToInventory(nextCell.getItem());
                nextCell.setItem(null);
            }
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }


    public void addItemToInventory(Item item) {
        items.add(item);
    }

    public List<Item> getItemsFromInventory() {
        return items;
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
