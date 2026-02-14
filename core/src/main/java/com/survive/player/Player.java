package com.survive.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {

    Texture img;
    TextureRegion stand, walk1, walk2;
    float x, y;
    float speed = 2f;

    boolean moving = false;

    public Player(float spawnX, float spawnY){
        x = spawnX;
        y = spawnY;

        img = new Texture("player.png");
        stand = new TextureRegion(img,0,0,15,15);
        walk1 = new TextureRegion(img,15,0,15,15);
        walk2 = new TextureRegion(img,30,0,15,15);
    }

    public void render(SpriteBatch batch){
        TextureRegion frame = stand;
        if(moving){
            frame = walk1; // пока просто ходьба, потом можно анимацию
        }
        batch.draw(frame,x,y,30,30); // увеличили тайл для наглядности
    }

    public void move(float dx, float dy){
        if(dx!=0 || dy!=0) moving=true;
        else moving=false;

        x += dx*speed;
        y += dy*speed;
    }

    public float getX(){return x;}
    public float getY(){return y;}
}
