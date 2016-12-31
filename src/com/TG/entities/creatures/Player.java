/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.entities.creatures;

import com.TG.gfx.Assets;
import com.TG.launch.Game;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author BHT
 */
public class Player extends Creature{
    public static final float DEFAULT_SPEED=1;
    public static final int DEFAULT_PLAYER_WIDTH=48;
    public static final int DEFAULT_PLAYER_HEIGHT=52;
    public static final int DEFAULT_HEALTH_BAR_RELATIVE_Y=-10;
    public static final int DEFAULT_HEALTH_BAR_MAX_WIDTH=40;
    public static final int DEFAULT_HEALTH_BAR_HEIGHT=5;
    private Game game;
    
    private float speed;
    private float xMove,yMove;
    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    
    public Player(Game game, float x, float y,Color color) {
        super(x, y,DEFAULT_PLAYER_WIDTH,DEFAULT_PLAYER_HEIGHT,color);
        this.game = game;
        speed=DEFAULT_SPEED;
    }
    
    public void move()
    {
        x+=xMove;
        y+=yMove;
    }
    private void getInput()
    {
        xMove=0;
        yMove=0;
        if (game.getKeyManager().up) {
            yMove=-speed;
        }
        if (game.getKeyManager().down) {
            yMove=speed;
        }
        if (game.getKeyManager().left) {
            xMove=-speed;
        }
        if (game.getKeyManager().right) {
            xMove=speed;
        }
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.sf, (int)x, (int)y,width,height, null);
        g.setColor(color);
        g.fillRect((int)x, (int)y+DEFAULT_HEALTH_BAR_RELATIVE_Y, (int)((float)currentHealth/health*DEFAULT_HEALTH_BAR_MAX_WIDTH), DEFAULT_HEALTH_BAR_HEIGHT);
    }

    @Override
    public void tick() {
        getInput();
        move();
    }
    
}
