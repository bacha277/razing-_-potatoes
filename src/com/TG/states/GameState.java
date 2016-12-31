/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.states;

import com.TG.entities.creatures.Player;
import com.TG.gfx.Assets;
import com.TG.launch.Game;
import com.TG.tiles.Tile;
import com.TG.worlds.World;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author BHT
 */
public class GameState extends State{
    public static final Color PLAYER_1_COLOR=Color.blue;
    public static final Color PLAYER_2_COLOR=Color.red;
    private Player player1,player2;
    private World world;
    public GameState(Game game) {
        super(game);
        player1=new Player(game, 100, 100,PLAYER_1_COLOR);
        player2=new Player(game, 200, 200,PLAYER_2_COLOR);
        world=new World("res/worlds/world1.txt");
    }

    
    
    @Override
    public void tick() {
        world.tick();
        player1.tick();
        player2.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player1.render(g);
        player2.render(g);
        
    }
}
