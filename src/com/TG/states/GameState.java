/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.states;

import com.TG.entities.abilities.Raze;
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
        player1.setDirectionDown(true);
        player2=new Player(game, PLAYER_2_START_X, PLAYER_2_START_Y,PLAYER_2_COLOR);
        player2.setDirectionUp(true);
        this.game=game;
        world=new World("res/worlds/world1.txt");
    }
    private void getInput(Game game)
    {
        player1.setxMove(0);
        player1.setyMove(0);
        player2.setxMove(0);
        player2.setyMove(0);
        player1.setNear(null);
        player1.setMedium(null);
        player1.setFar(null);
        player2.setNear(null);
        player2.setMedium(null);
        player2.setFar(null);
        if (game.getKeyManager().up) {
            player1.moveUp();
        }
        if (game.getKeyManager().down) {
            player1.moveDown();
        }
        if (game.getKeyManager().left) {
            player1.moveLeft();
        }
        if (game.getKeyManager().right) {
            player1.moveRight();
        }
        if (game.getKeyManager().up2) {
            player2.moveUp();
        }
        if (game.getKeyManager().down2) {
            player2.moveDown();
        }
        if (game.getKeyManager().left2) {
            player2.moveLeft();
        }
        if (game.getKeyManager().right2) {
            player2.moveRight();
        }
        if (game.getKeyManager().near) {
            player1.setNear(new Raze(player1.getNearX(),player1.getNearY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
        }
        if (game.getKeyManager().medium) {
            player1.setNear(new Raze(player1.getMediumX(),player1.getMediumY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
        }
        if (game.getKeyManager().far) {
            player1.setNear(new Raze(player1.getFarX(),player1.getFarY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
        }
        if (game.getKeyManager().near2) {
            player2.setNear(new Raze(player2.getNearX(),player2.getNearY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
        }
        if (game.getKeyManager().medium2) {
            player2.setNear(new Raze(player2.getMediumX(),player2.getMediumY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
        }
        if (game.getKeyManager().far2) {
            player2.setNear(new Raze(player2.getFarX(),player2.getFarY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
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
