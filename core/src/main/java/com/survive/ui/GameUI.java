package com.survive.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameUI {

    Texture ui;
    TextureRegion[] parts = new TextureRegion[6];

    public float joyX = 80;
    public float joyY = 80;

    public GameUI() {
        ui = new Texture("UI.png");

        // элементы 15x15
        parts[0] = new TextureRegion(ui,0,0,15,15);    // обычная кнопка
        parts[1] = new TextureRegion(ui,0,15,15,15);   // круглая кнопка
        parts[2] = new TextureRegion(ui,15,0,15,15);   // джойстик
        parts[3] = new TextureRegion(ui,15,15,15,15);  // центр джойстика
        parts[4] = new TextureRegion(ui,30,0,15,15);   // вылеталка урон
        parts[5] = new TextureRegion(ui,30,15,15,15);  // вылеталка хил
    }

    public void render(SpriteBatch batch){
        // обычная кнопка
        batch.draw(parts[0],260,40,40,40);

        // круглая кнопка
        batch.draw(parts[1],20,200,30,30);

        // джойстик
        batch.draw(parts[2],40,40,80,80);
        batch.draw(parts[3],joyX,joyY,40,40);
    }

    public void drawDamage(SpriteBatch batch,float x,float y){
        batch.draw(parts[4],x,y,20,20);
    }

    public void drawHeal(SpriteBatch batch,float x,float y){
        batch.draw(parts[5],x,y,20,20);
    }
}
