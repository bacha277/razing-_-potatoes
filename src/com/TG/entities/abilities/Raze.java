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
    public static final int DEFAULT_RAZE_WIDTH=30;
    public static final int DEFAULT_RAZE_HEIGHT=30;
    public static final int DEFAULT_NEAR_RANGE=50;
    public static final int DEFAULT_MEDIUM_RANGE=100;
    public static final int DEFAULT_FAR_RANGE=200;
    
    public Raze(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(DEFAULT_RAZE_IMAGE, (int) x, (int) y, DEFAULT_RAZE_WIDTH, DEFAULT_RAZE_HEIGHT, null);
    }

   
    
}
