/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.entities.creatures;

import com.TG.entities.Entity;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author BHT
 */
public abstract class Creature extends Entity{
    public static final int DEFAULT_HEALTH=3;
    protected int health;
    protected int currentHealth;
    protected Color color;
    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public Creature(float x, float y,int width,int height,Color color) {
        super(x, y,width,height);
        this.color=color;
        health=DEFAULT_HEALTH;
        currentHealth=health;
    }
}
