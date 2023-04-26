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

        if(nextCell.getActor() != null){

            actorAttack(nextCell);
            actorDeath(nextCell);

        }

        if (nextCell.getType().equals(CellType.FLOOR) && nextCell.getActor() == null) {
            if (nextCell.getItem() != null) {
                addItemToInventory(nextCell.getItem());
                nextCell.getItem().addEffectToPlayer(cell.getActor());
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

    private void actorDeath(Cell nextCell){
        if(nextCell.getActor().getHealth() <= 0){
            nextCell.setActor(null);
        }
    }

    private void actorAttack(Cell nextCell){
        if((cell.getActor().typeOfActor().equals("player") &&
                nextCell.getActor().typeOfActor().equals("enemy")) ||
                (cell.getActor().typeOfActor().equals("enemy") &&
                        nextCell.getActor().typeOfActor().equals("player"))){
            nextCell.getActor().setHealth(nextCell.getActor().getHealth() - cell.getActor().getAttackStrength());
        }
    }

    public abstract int getHealth();

    public abstract void setHealth(int number);

    public abstract void addHealthPoints(int number);

    public abstract int getAttackStrength();

    public abstract void addAttackStrength(int number);

    protected abstract String typeOfActor();

}
