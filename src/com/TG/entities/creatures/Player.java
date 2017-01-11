/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.entities.creatures;

import com.TG.entities.abilities.Raze;
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
    public static final int DEFAULT_RAZE_COOLDOWN=100;
    public static final BufferedImage DEFAULT_PLAYER_IMAGE=Assets.sf;
    private Game game;
    private boolean directionUp,directionDown,directionLeft,directionRight;
    private float speed;
    private float xMove,yMove;
    private Raze near,medium,far;
    private float nearX,nearY,mediumX,mediumY,farX,farY;
    private int nearCD,mediumCD,farCD;

    public int getNearCD() {
        return nearCD;
    }

    public void setNearCD(int nearCD) {
        this.nearCD = nearCD;
    }

    public int getMediumCD() {
        return mediumCD;
    }

    public void setMediumCD(int mediumCD) {
        this.mediumCD = mediumCD;
    }

    public int getFarCD() {
        return farCD;
    }

    public void setFarCD(int farCD) {
        this.farCD = farCD;
    }

    
    
    public float getNearX() {
        return nearX;
    }

    public void setNearX(float nearX) {
        this.nearX = nearX;
    }

    public float getNearY() {
        return nearY;
    }

    public void setNearY(float nearY) {
        this.nearY = nearY;
    }

    public float getMediumX() {
        return mediumX;
    }

    public void setMediumX(float mediumX) {
        this.mediumX = mediumX;
    }

    public float getMediumY() {
        return mediumY;
    }

    public void setMediumY(float mediumY) {
        this.mediumY = mediumY;
    }

    public float getFarX() {
        return farX;
    }

    public void setFarX(float farX) {
        this.farX = farX;
    }

    public float getFarY() {
        return farY;
    }

    public void setFarY(float farY) {
        this.farY = farY;
    }
    

    public Raze getNear() {
        return near;
    }

    public void setNear(Raze near) {
        this.near = near;
    }

    public Raze getMedium() {
        return medium;
    }

    public void setMedium(Raze medium) {
        this.medium = medium;
    }

    public Raze getFar() {
        return far;
    }

    public void setFar(Raze far) {
        this.far = far;
    }
    
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
        nearCD=0;
        mediumCD=0;
        farCD=0;
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
    private void updateRazePosition()
    {
        if (directionUp) {
            nearX=x-15;
            nearY=y-20-Raze.DEFAULT_NEAR_RANGE;
            mediumX=x-15;
            mediumY=y-20-Raze.DEFAULT_MEDIUM_RANGE;
            farX=x-15;
            farY=y-20-Raze.DEFAULT_FAR_RANGE;
        }
        else if (directionDown) {
            nearX=x-15;
            nearY=y+20+Raze.DEFAULT_NEAR_RANGE;
            mediumX=x-15;
            mediumY=y+20+Raze.DEFAULT_MEDIUM_RANGE;
            farX=x-15;
            farY=y+20+Raze.DEFAULT_FAR_RANGE;
        }
        else if (directionLeft) {
            nearX=x-40-Raze.DEFAULT_NEAR_RANGE;
            nearY=y;
            mediumX=x-40-Raze.DEFAULT_MEDIUM_RANGE;
            mediumY=y;
            farX=x-40-Raze.DEFAULT_FAR_RANGE;
            farY=y;
        }
        else if (directionRight) {
            nearX=x+40+Raze.DEFAULT_NEAR_RANGE;
            nearY=y;
            mediumX=x+40+Raze.DEFAULT_MEDIUM_RANGE;
            mediumY=y;
            farX=x+40+Raze.DEFAULT_FAR_RANGE;
            farY=y;
        }
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
        if (near!=null) {
            near.render(g);
        }
        if (medium!=null) {
            medium.render(g);
        }
        if (far!=null) {
            far.render(g);
        }
    }
    private void updateLastTime(Raze r)
    {
        
    }
    @Override
    public void tick() {
        if (nearCD>0) {
            nearCD-=1;
        } 
        if (mediumCD>0) {
            mediumCD-=1;
        } 
        if (farCD>0) {
            farCD-=1;
        }
        if (near != null) {
            if (near.getLastTime() > 0) {
                near.setLastTime(near.getLastTime() - 1);
            } else if (near.getLastTime() == 0) {
                near = null;
            }

        }
        if (medium != null) {
            if (medium.getLastTime() > 0) {
                medium.setLastTime(medium.getLastTime() - 1);
            } else if (medium.getLastTime() == 0) {
                medium = null;
            }

        }
        if (far != null) {
            if (far.getLastTime() > 0) {
                far.setLastTime(far.getLastTime() - 1);
            } else if (far.getLastTime() == 0) {
                far = null;
            }

        }
        move();
        updateRazePosition();
    }
    
}
