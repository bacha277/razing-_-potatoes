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
import java.awt.image.BufferedImage;

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
    public static final BufferedImage DEFAULT_PLAYER_IMAGE=Assets.sf;
    private Game game;
    private boolean directionUp,directionDown,directionLeft,directionRight;
    private float speed;
    private float xMove,yMove;

    public boolean isDirectionUp() {
        return directionUp;
    }

    public void setDirectionUp(boolean directionUp) {
        this.directionUp = directionUp;
    }

    public boolean isDirectionDown() {
        return directionDown;
    }

    public void setDirectionDown(boolean directionDown) {
        this.directionDown = directionDown;
    }

    public boolean isDirectionLeft() {
        return directionLeft;
    }

    public void setDirectionLeft(boolean directionLeft) {
        this.directionLeft = directionLeft;
    }

    public boolean isDirectionRight() {
        return directionRight;
    }

    public void setDirectionRight(boolean directionRight) {
        this.directionRight = directionRight;
    }
    
    public Game getGame() {
        return game;
    }
    
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
    public void turnUp()
    {
        directionUp=true;
        directionDown=false;
        directionLeft=false;
        directionRight=false;
    }
    public void turnDown()
    {
        directionUp=false;
        directionDown=true;
        directionLeft=false;
        directionRight=false;
    }
    public void turnLeft()
    {
        directionUp=false;
        directionDown=false;
        directionLeft=true;
        directionRight=false;
    }
    public void turnRight()
    {
        directionUp=false;
        directionDown=false;
        directionLeft=false;
        directionRight=true;
    }
    public void move()
    {
        x+=xMove;
        y+=yMove;
    }
    public void moveUp()
    {
        turnUp();
        yMove=-speed;
    }
    public void moveDown()
    {
        turnDown();
        yMove=speed;
    }
    public void moveLeft()
    {
        turnLeft();
        xMove=-speed;
    }
    public void moveRight()
    {
        turnRight();
        xMove=speed;
    }
    
    private void drawHealthBar(Graphics g)
    {
        g.setColor(color);
        g.fillRect((int)x, (int)y+DEFAULT_HEALTH_BAR_RELATIVE_Y, (int)((float)currentHealth/health*DEFAULT_HEALTH_BAR_MAX_WIDTH), DEFAULT_HEALTH_BAR_HEIGHT);
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(DEFAULT_PLAYER_IMAGE, (int)x, (int)y,width,height, null);
        drawHealthBar(g);
    }

    @Override
    public void tick() {
        move();
    }
    
}
