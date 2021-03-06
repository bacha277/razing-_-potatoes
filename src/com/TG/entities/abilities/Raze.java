/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.entities.abilities;

import com.TG.entities.Entity;
import com.TG.gfx.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author BHT
 */
public class Raze extends Entity{
    public static final BufferedImage DEFAULT_RAZE_IMAGE=Assets.fire;
    public static final int DEFAULT_RAZE_WIDTH=40;
    public static final int DEFAULT_RAZE_HEIGHT=40;
    public static final int DEFAULT_NEAR_RANGE=25;
    public static final int DEFAULT_MEDIUM_RANGE=100;
    public static final int DEFAULT_FAR_RANGE=175;
    public static final int DEFAULT_LAST_TIME=30;
    private int lastTime;

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }
    
    public Raze(float x, float y, int width, int height) {
        super(x, y, width, height);
        lastTime=DEFAULT_LAST_TIME;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(DEFAULT_RAZE_IMAGE, (int) x-DEFAULT_RAZE_WIDTH/2, (int) y-DEFAULT_RAZE_HEIGHT/2, DEFAULT_RAZE_WIDTH, DEFAULT_RAZE_HEIGHT, null);
    }

   
    
}
