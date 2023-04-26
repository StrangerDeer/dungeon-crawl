package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements Drawable {
    private Cell cell;

    private boolean hasKey = false;

    private int health;
    private List<Item> items;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
        this.items = new ArrayList<>();
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if ((nextCell.getType().equals(CellType.FLOOR) || nextCell.getType().equals(CellType.DOOR_OPEN)) && nextCell.getActor() == null) {
            moveActor(nextCell);
        }
        if (nextCell.getType().equals(CellType.DOOR_CLOSED)) {
            if (cell.getActor().checkIfPlayerHasKey()) {
                nextCell.setType(CellType.DOOR_OPEN);
            }
        }
    }

    private void moveActor(Cell nextCell) {
        if (nextCell.getItem() != null) {
            pickUpItem(nextCell);
        }
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }

    private void pickUpItem(Cell nextCell) {
        addItemToInventory(nextCell.getItem());
        nextCell.getItem().addEffectToPlayer(cell.getActor());
        nextCell.setItem(null);
    }

    public void addItemToInventory(Item item) {
        items.add(item);
    }

    public List<Item> getItemsFromInventory() {
        return items;
    }

    public boolean checkIfPlayerHasKey() {
        return hasKey;
    }

    public void addKey() {
        hasKey = true;
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

    public abstract int getHealth();

    public abstract void setHealth(int number);

    public abstract void addHealthPoints(int number);

    public abstract int getAttackStrength();

    public abstract void addAttackStrength(int number);
}
