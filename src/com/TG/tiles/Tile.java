/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author BHT
 */
public class Tile {
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile=new GrassTile(0);
    public static Tile rockTile=new RockTile(1);
    public static Tile dirtTile=new DirtTile(2);
    public static Tile waterTile=new WaterTile(3);
    
    public static final int TILEWIDTH=16,TILEHEIGHT=16;
    
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        tiles[id]=this;
    }

    public int getId() {
        return id;
    }
    
    public boolean isSolid()
    {
        return false;
    }
    
    public void tick()
    {
    }
    
    public void render(Graphics g,int x,int y)
    {
        g.drawImage(texture, x, y,TILEWIDTH,TILEHEIGHT , null);
    }
}
