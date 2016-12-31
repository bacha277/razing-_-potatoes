/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.worlds;

import com.TG.tiles.Tile;
import com.TG.utils.Util;
import java.awt.Graphics;


/**
 *
 * @author BHT
 */
public class World {
    private int width,height,spawnX,spawnY;
    private int[][] tiles;
    
    public World(String path) {
        loadWorld(path);
    }
    public void loadWorld(String path)
    {
        String file=Util.loadFileAsString(path);
        String[] token=file.split("\\s+");
        width=Util.parseInt(token[0]);
        height=Util.parseInt(token[1]);
        spawnX=Util.parseInt(token[2]);
        spawnY=Util.parseInt(token[3]);
        tiles=new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y]=Util.parseInt(token[(x+y*width)+4]);
            }
        }
    }
    public void tick()
    {
        
    }
    public void render(Graphics g)
    {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT);
            }
        }
    }
    public Tile getTile(int x,int y)
    {
        Tile t=Tile.tiles[tiles[x][y]];
        if (t==null) {
            return Tile.dirtTile;
        }
        return t;
    }
}
