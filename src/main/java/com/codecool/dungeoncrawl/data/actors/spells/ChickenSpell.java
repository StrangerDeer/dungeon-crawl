package com.codecool.dungeoncrawl.data.actors.spells;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class ChickenSpell extends Spell{

    private boolean exist;

    private boolean moveRight;
    private boolean moveLeft;
    private boolean moveDown;

    private boolean moveUp;

    private int damage = 5;
    public ChickenSpell(Cell cell, int x, int y) {
        super(cell, x, y);

        if(x > 0){
            this.moveRight = true;
            this.exist = true;
        }else if(x < 0){
            this.moveLeft = true;
            this.exist = true;
        }else if(y > 0){
            this.moveDown = true;
            this.exist = true;
        }else if(y < 0){
            this.moveUp = true;
            this.exist = true;
        }
    }

    private void dealPlayerDamage(int position){
        if(moveRight &&
                cell.getNeighbor(position + 1, 0).getActor() != null &&
                cell.getNeighbor(position + 1, 0).getActor().getTileName().equals("player") ){
            cell.getNeighbor(position + 1, 0).getActor().setHealth(
                    cell.getNeighbor(position + 1, 0).getActor().getHealth() - damage);
            this.exist = false;
        }else if((moveDown &&
                cell.getNeighbor(0, position + 1).getActor() != null &&
                cell.getNeighbor(0, position + 1).getActor().getTileName().equals("player") )){
            cell.getNeighbor(0, position + 1).getActor().setHealth(
                    cell.getNeighbor(0, position + 1).getActor().getHealth() - damage);
            this.exist = false;
        }else if(moveUp &&
                cell.getNeighbor(0, position - 1).getActor() != null &&
                cell.getNeighbor(0, position - 1).getActor().getTileName().equals("player")){
            cell.getNeighbor(0, position - 1).getActor().setHealth(
                    cell.getNeighbor(0, position - 1).getActor().getHealth() - damage);
            this.exist = false;
        }else if(moveLeft &&
                cell.getNeighbor(position - 1, 0).getActor() != null &&
                cell.getNeighbor(position - 1, 0).getActor().getTileName().equals("player") ){
            cell.getNeighbor(position - 1, 0).getActor().setHealth(
                    cell.getNeighbor(position - 1, 0).getActor().getHealth() - damage);
            this.exist = false;
        }
    }

    @Override
    public void moveEnemy() {
        moveFieldChecker(0, CellType.GRASS);
        makeMove(0);

    }

    @Override
    protected void moveFieldChecker(int position, CellType floorType) {
        if (moveRight &&
                !cell.getNeighbor(position + 1, 0).getType().equals(CellType.GRASS)){
            this.exist = false;
        }else if(moveDown &&
                !cell.getNeighbor(0, position + 1).getType().equals(CellType.GRASS)){
            this.exist = false;
        }else if(moveUp &&
                !cell.getNeighbor(0, position - 1).getType().equals(CellType.GRASS)){
            this.exist = false;
        }else if(moveLeft &&
                !cell.getNeighbor(position - 1, 0).getType().equals(CellType.GRASS)){
            this.exist = false;
        }

        dealPlayerDamage(position);
    }

    @Override
    protected void makeMove(int position) {
        if (moveRight){
            position++;
            move(position,0);
        }else if(moveDown){
            position++;
            move(0,position);
        }else if(moveUp){
            position--;
            move(0,position);
        }else if(moveLeft){
            position--;
            move(position, 0);
        }
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void setHealth(int number) {

    }

    @Override
    public void addHealthPoints(int number) {

    }

    @Override
    public int getAttackStrength() {
        return 0;
    }

    @Override
    public void addAttackStrength(int number) {

    }

    @Override
    public String getTileName() {

        if(exist){
            return "chicken_spell";
        }

        cell.removeSpell(this);
        cell.setType(CellType.WATER);
        return "water";
    }
}
