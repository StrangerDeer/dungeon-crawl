package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(7, 0));
        tileMap.put("wall", new Tile(11, 18));
        tileMap.put("outside_wall", new Tile(13, 16));
        tileMap.put("floor", new Tile(16, 0));
        tileMap.put("player", new Tile(25, 7));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("Longsword", new Tile(0, 29));
        tileMap.put("Uzi", new Tile(9, 31));
        tileMap.put("Golden key", new Tile(16, 23));
        tileMap.put("Red apple", new Tile(15, 29));
        tileMap.put("door_closed", new Tile(3, 4));
        tileMap.put("door_open", new Tile(4, 4));
        tileMap.put("giant", new Tile(30, 6));
        tileMap.put("wizard", new Tile(25, 6));
        tileMap.put("spider", new Tile(30, 5));
        tileMap.put("Cheesy cheese", new Tile(18, 28));
        tileMap.put("grass", new Tile(5, 0));
        tileMap.put("water", new Tile(8, 5));
        tileMap.put("bridge", new Tile(6, 5));
        tileMap.put("chicken", new Tile(26, 7));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
