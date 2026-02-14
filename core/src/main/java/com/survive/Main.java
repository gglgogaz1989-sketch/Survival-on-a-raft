package com.survive;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.survive.ui.GameUI;

public class Main extends ApplicationAdapter {

    SpriteBatch batch;
    Texture tiles;
    GameUI gameUI;

    final int TILE = 15;

    int[][] tileCoords = {
            {0,0},    // 0 пол
            {0,15},   // 1 спавн
            {15,0},   // 2 забор
            {15,15},  // 3 верх
            {30,0},   // 4 вылеталка урон
            {30,15}   // 5 вылеталка хил
    };

    int[][] map = {
            {3,3,3,3,3,3,3,3,3},
            {4,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,2},
            {2,0,0,0,0,0,0,0,2},
            {2,0,0,0,1,0,0,0,2},
            {2,0,0,0,0,0,0,0,2},
            {3,3,3,3,3,3,3,3,3}
    };

    @Override
    public void create() {
        batch = new SpriteBatch();
        tiles = new Texture("tiles.png");
        gameUI = new GameUI();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        // рисуем карту
        for(int y=0;y<map.length;y++){
            for(int x=0;x<map[0].length;x++){
                int id = map[y][x];
                int sx = tileCoords[id][0];
                int sy = tileCoords[id][1];

                batch.draw(
                        tiles,
                        x*TILE*2,
                        (map.length-y)*TILE*2,
                        TILE,TILE,
                        sx,sy,
                        TILE,TILE,
                        false,false
                );
            }
        }

        // рисуем UI поверх
        gameUI.render(batch);

        batch.end();
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration c = new Lwjgl3ApplicationConfiguration();
        c.setTitle("Survive");
        c.setWindowedMode(400,300);
        new Lwjgl3Application(new Main(), c);
    }
}
