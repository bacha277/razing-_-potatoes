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
    private Game game;
    public GameState(Game game) {
        super(game);
        player1=new Player(game, 100, 100,PLAYER_1_COLOR);
        player2=new Player(game, 200, 200,PLAYER_2_COLOR);
        this.game=game;
        world=new World("res/worlds/world1.txt");
    }
    private void getInput1(Game game)
    {
        player1.setUp(false);
        player1.setDown(false);
        player1.setLeft(false);
        player1.setRight(false);
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
    }
    private void getInput2(Game game)
    {
        player2.setUp(false);
        player2.setDown(false);
        player2.setLeft(false);
        player2.setRight(false);
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
        getInput1(game);
        player1.tick();
        getInput2(game);
        player2.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player1.render(g);
        player2.render(g);
        
    }
}
