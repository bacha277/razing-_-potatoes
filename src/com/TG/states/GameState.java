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
    public static final float PLAYER_1_START_X=220;
    public static final float PLAYER_2_START_X=220;
    public static final float PLAYER_1_START_Y=10;
    public static final float PLAYER_2_START_Y=590;
    private Player player1,player2;
    private World world;
    private Game game;
    public GameState(Game game) {
        super(game);
        player1=new Player(game, PLAYER_1_START_X, PLAYER_1_START_Y,PLAYER_1_COLOR);
        player2=new Player(game, PLAYER_2_START_X, PLAYER_2_START_Y,PLAYER_2_COLOR);
        this.game=game;
        world=new World("res/worlds/world1.txt");
    }
    private void getInput(Game game)
    {
        player1.setUp(false);
        player1.setDown(false);
        player1.setLeft(false);
        player1.setRight(false);
        player2.setUp(false);
        player2.setDown(false);
        player2.setLeft(false);
        player2.setRight(false);
        if (game.getKeyManager().up) {
            player1.setUp(true);
        }
        if (game.getKeyManager().down) {
            player1.setDown(true);
        }
        if (game.getKeyManager().left) {
            player1.setLeft(true);
        }
        if (game.getKeyManager().right) {
            player1.setRight(true);
        }
        if (game.getKeyManager().up2) {
            player2.setUp(true);
        }
        if (game.getKeyManager().down2) {
            player2.setDown(true);
        }
        if (game.getKeyManager().left2) {
            player2.setLeft(true);
        }
        if (game.getKeyManager().right2) {
            player2.setRight(true);
        }
    }
    
    @Override
    public void tick() {
        world.tick();
        getInput(game);
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
