package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.spells.ChickenSpell;
import com.codecool.dungeoncrawl.data.actors.spells.Spell;

public class Chicken extends Wizard {

    private int health = 200;

    private int attack = 3;
    private boolean moveUp = true;
    private boolean moveLeft;
    private boolean moveDown;
    private boolean moveRight;


    public Chicken(Cell cell) {
        super(cell);
    }

    private void attackView(){

        seeDown();
        seeUp();
        seeRight();
        seeLeft();

    }

    private void seeDown(){
        int view = 1;

        while(getCell().getNeighbor(0,view).getType().equals(CellType.GRASS)){
            if(checkPlayer(0,view)){
                ChickenSpell spell = new ChickenSpell(getCell().getNeighbor(0,1),0,1);
                getCell().addSpell(spell);
            };
            view++;
        }

    }

    private void seeUp(){
        int view = 1;

        while(getCell().getNeighbor(0,- view).getType().equals(CellType.GRASS)){
            if(checkPlayer(0, -view)){
                ChickenSpell spell = new ChickenSpell(getCell().getNeighbor(0, -1),0,-1);
                getCell().addSpell(spell);
            };
            view++;
        }
    }

    private void seeRight(){
        int view = 1;

        while(getCell().getNeighbor(view,0).getType().equals(CellType.GRASS)){
            if(checkPlayer(view,0)){
                ChickenSpell spell = new ChickenSpell(getCell().getNeighbor(1,0),1,0);
                getCell().addSpell(spell);
            };
            view++;
        }
    }

    private void seeLeft(){
        int view = 1;

        while(getCell().getNeighbor(- view,0).getType().equals(CellType.GRASS)){
            if(checkPlayer(- view, 0)){
                ChickenSpell spell = new ChickenSpell(getCell().getNeighbor(-1, 0),-1,0);
                getCell().addSpell(spell);
            };
            view++;
        }
    }

    private boolean checkPlayer(int x, int y){
        if(getCell().getNeighbor(x,y).getActor() != null &&
                getCell().getNeighbor(x,y).getActor().getTileName().equals("player")&&
                (y>1 || y<-1 || x>1 || x< -1)){
            return true;
        };
        return false;
    }


    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int number) {
        this.health = number;
    }

    @Override
    public void addHealthPoints(int number) {

    }

    @Override
    public int getAttackStrength() {
        return attack;
    }

    @Override
    public void addAttackStrength(int number) {

    }

    @Override
    public void moveEnemy() {
        moveFieldChecker(0);
        makeMove(0);
        attackView();
    }

    @Override
    protected void moveFieldChecker(int position) {

        if(!getCell().getNeighbor(0, position - 1).getType().equals(CellType.GRASS) &&
                getCell().getNeighbor(position - 1, 0).getType().equals(CellType.GRASS)){
            moveUp = false;
            moveLeft = true;
        }else if (!getCell().getNeighbor(position - 1, 0).getType().equals(CellType.GRASS) &&
                getCell().getNeighbor(0, position + 1).getType().equals(CellType.GRASS)){
            moveLeft = false;
            moveDown = true;
        }else if (!getCell().getNeighbor(0, position + 1).getType().equals(CellType.GRASS) &&
                getCell().getNeighbor(position + 1, 0).getType().equals(CellType.GRASS)){
            moveDown = false;
            moveRight = true;
        }else if(!getCell().getNeighbor(position + 1, 0).getType().equals(CellType.GRASS) &&
                getCell().getNeighbor(0, position - 1).getType().equals(CellType.GRASS)){
            moveRight = false;
            moveUp = true;
        }
    }

    @Override
    protected void makeMove(int position) {
        if(moveRight){
            position++;
            move(position,0);
        }else if (moveLeft){
            position--;
            move(position, 0);
        }else if(moveUp){
            position--;
            move(0, position);
        } else if (moveDown) {
            position++;
            move(0, position);
        }
    }

    @Override
    public String getTileName() {

        if (health <= 0) {
            return "grass";
        }

        return "chicken";
    }
}
