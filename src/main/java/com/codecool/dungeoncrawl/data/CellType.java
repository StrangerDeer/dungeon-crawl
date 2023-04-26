package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    DOOR_CLOSED("door_closed"),
    DOOR_OPEN("door_open"),
    BRIDGE("bridge"),
    GRASS("grass"),
    WATER("water"),
    OUTSIDE_WALL("outside_wall");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
