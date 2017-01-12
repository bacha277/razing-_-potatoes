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
    public static final float PLAYER_1_ABILITIES_X=0;
    public static final float PLAYER_1_ABILITIES_Y=155;
    public static final float PLAYER_2_ABILITIES_X=320;
    public static final float PLAYER_2_ABILITIES_Y=440;
    public static final int DEFAULT_ABILITY_WIDTH=40;
    public static final int DEFAULT_ABILITY_HEIGHT=40;
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
            if (player1.getNearCD()==0) {
                player1.setImg(Player.RAZING_PLAYER_IMAGE);
                player1.setRazeLastingTime(Raze.DEFAULT_LAST_TIME);
                player1.setNear(new Raze(player1.getNearX(),player1.getNearY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
                player1.setNearCD(Player.DEFAULT_RAZE_COOLDOWN);
                if (player1.getNearX()>player2.getX()-Raze.DEFAULT_RAZE_WIDTH
                        &&player1.getNearX()<player2.getX()+Player.DEFAULT_PLAYER_WIDTH+Raze.DEFAULT_RAZE_WIDTH
                        &&player1.getNearY()>player2.getY()-Raze.DEFAULT_RAZE_HEIGHT
                        &&player1.getNearY()<player2.getY()+Player.DEFAULT_PLAYER_HEIGHT+Raze.DEFAULT_RAZE_HEIGHT) {
                    player2.setCurrentHealth(player2.getCurrentHealth()-1);
                }
            }
        }
        if (game.getKeyManager().medium) {
            if (player1.getMediumCD()==0) {
                player1.setImg(Player.RAZING_PLAYER_IMAGE);
                player1.setRazeLastingTime(Raze.DEFAULT_LAST_TIME);
                player1.setMedium(new Raze(player1.getMediumX(),player1.getMediumY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
                player1.setMediumCD(Player.DEFAULT_RAZE_COOLDOWN);
                if (player1.getMediumX()>player2.getX()-Raze.DEFAULT_RAZE_WIDTH
                        &&player1.getMediumX()<player2.getX()+Player.DEFAULT_PLAYER_WIDTH+Raze.DEFAULT_RAZE_WIDTH
                        &&player1.getMediumY()>player2.getY()-Raze.DEFAULT_RAZE_HEIGHT
                        &&player1.getMediumY()<player2.getY()+Player.DEFAULT_PLAYER_HEIGHT+Raze.DEFAULT_RAZE_HEIGHT) {
                    player2.setCurrentHealth(player2.getCurrentHealth()-1);
                }
            }
        }
        if (game.getKeyManager().far) {
            if (player1.getFarCD() == 0) {
                player1.setImg(Player.RAZING_PLAYER_IMAGE);
                player1.setRazeLastingTime(Raze.DEFAULT_LAST_TIME);
                player1.setFar(new Raze(player1.getFarX(), player1.getFarY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
                player1.setFarCD(Player.DEFAULT_RAZE_COOLDOWN);
                if (player1.getFarX()>player2.getX()-Raze.DEFAULT_RAZE_WIDTH
                        &&player1.getFarX()<player2.getX()+Player.DEFAULT_PLAYER_WIDTH+Raze.DEFAULT_RAZE_WIDTH
                        &&player1.getFarY()>player2.getY()-Raze.DEFAULT_RAZE_HEIGHT
                        &&player1.getFarY()<player2.getY()+Player.DEFAULT_PLAYER_HEIGHT+Raze.DEFAULT_RAZE_HEIGHT) {
                    player2.setCurrentHealth(player2.getCurrentHealth()-1);
                }
            }
        }
        if (game.getKeyManager().near2) {
            if (player2.getNearCD()==0) {
                player2.setImg(Player.RAZING_PLAYER_IMAGE);
                player2.setRazeLastingTime(Raze.DEFAULT_LAST_TIME);
                player2.setNear(new Raze(player2.getNearX(),player2.getNearY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
                player2.setNearCD(Player.DEFAULT_RAZE_COOLDOWN);
                if (player2.getNearX()>player1.getX()-Raze.DEFAULT_RAZE_WIDTH
                        &&player2.getNearX()<player1.getX()+Player.DEFAULT_PLAYER_WIDTH+Raze.DEFAULT_RAZE_WIDTH
                        &&player2.getNearY()>player1.getY()-Raze.DEFAULT_RAZE_HEIGHT
                        &&player2.getNearY()<player1.getY()+Player.DEFAULT_PLAYER_HEIGHT+Raze.DEFAULT_RAZE_HEIGHT) {
                    player1.setCurrentHealth(player1.getCurrentHealth()-1);
                }
            }
        }
        if (game.getKeyManager().medium2) {
            if (player2.getMediumCD()==0) {
                player2.setImg(Player.RAZING_PLAYER_IMAGE);
                player2.setRazeLastingTime(Raze.DEFAULT_LAST_TIME);
                player2.setMedium(new Raze(player2.getMediumX(),player2.getMediumY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
                player2.setMediumCD(Player.DEFAULT_RAZE_COOLDOWN);
                if (player2.getMediumX()>player1.getX()-Raze.DEFAULT_RAZE_WIDTH
                        &&player2.getMediumX()<player1.getX()+Player.DEFAULT_PLAYER_WIDTH+Raze.DEFAULT_RAZE_WIDTH
                        &&player2.getMediumY()>player1.getY()-Raze.DEFAULT_RAZE_HEIGHT
                        &&player2.getMediumY()<player1.getY()+Player.DEFAULT_PLAYER_HEIGHT+Raze.DEFAULT_RAZE_HEIGHT) {
                    player1.setCurrentHealth(player1.getCurrentHealth()-1);
                }
            }
        }
        if (game.getKeyManager().far2) {
            if (player2.getFarCD() == 0) {
                player2.setImg(Player.RAZING_PLAYER_IMAGE);
                player2.setRazeLastingTime(Raze.DEFAULT_LAST_TIME);
                player2.setFar(new Raze(player2.getFarX(), player2.getFarY(), Raze.DEFAULT_RAZE_WIDTH, Raze.DEFAULT_RAZE_HEIGHT));
                player2.setFarCD(Player.DEFAULT_RAZE_COOLDOWN);
                if (player2.getFarX()>player1.getX()-Raze.DEFAULT_RAZE_WIDTH
                        &&player2.getFarX()<player1.getX()+Player.DEFAULT_PLAYER_WIDTH+Raze.DEFAULT_RAZE_WIDTH
                        &&player2.getFarY()>player1.getY()-Raze.DEFAULT_RAZE_HEIGHT
                        &&player2.getFarY()<player1.getY()+Player.DEFAULT_PLAYER_HEIGHT+Raze.DEFAULT_RAZE_HEIGHT) {
                    player1.setCurrentHealth(player1.getCurrentHealth()-1);
                }
            }
        }
        
    }
    
    @Override
    public void tick() {
        world.tick();
        getInput(game);
        player1.tick();
        player2.tick();
        if (player1.getCurrentHealth()<1) {
            EndState endState = (EndState) this.game.getEndState();
            endState.setWinner(2);
            State.setState(endState);
        }
        else if (player2.getCurrentHealth()<1) {
            EndState endState = (EndState) this.game.getEndState();
            endState.setWinner(1);
            State.setState(endState);
        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player1.render(g);
        player2.render(g);      
        coolDownRender(g, player1, player2);
    }
    public void coolDownRender(Graphics g,Player player1,Player player2)
    {
        if (player1.getNearCD()>0) {
            g.drawImage(Assets.cooldown, (int)PLAYER_1_ABILITIES_X, (int)PLAYER_1_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        else if (player1.getNearCD()==0) {
            g.drawImage(Assets.ability, (int)PLAYER_1_ABILITIES_X, (int)PLAYER_1_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        if (player1.getMediumCD()>0) {
            g.drawImage(Assets.cooldown, (int)PLAYER_1_ABILITIES_X+DEFAULT_ABILITY_WIDTH+20, (int)PLAYER_1_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        else if (player1.getMediumCD()==0) {
            g.drawImage(Assets.ability, (int)PLAYER_1_ABILITIES_X+DEFAULT_ABILITY_WIDTH+20, (int)PLAYER_1_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        if (player1.getFarCD()>0) {
            g.drawImage(Assets.cooldown, (int)PLAYER_1_ABILITIES_X+DEFAULT_ABILITY_WIDTH*2+20*2, (int)PLAYER_1_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        else if (player1.getFarCD()==0) {
            g.drawImage(Assets.ability, (int)PLAYER_1_ABILITIES_X+DEFAULT_ABILITY_WIDTH*2+20*2, (int)PLAYER_1_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        
        if (player2.getNearCD()>0) {
            g.drawImage(Assets.cooldown, (int)PLAYER_2_ABILITIES_X, (int)PLAYER_2_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        else if (player2.getNearCD()==0) {
            g.drawImage(Assets.ability, (int)PLAYER_2_ABILITIES_X, (int)PLAYER_2_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        if (player2.getMediumCD()>0) {
            g.drawImage(Assets.cooldown, (int)PLAYER_2_ABILITIES_X+DEFAULT_ABILITY_WIDTH+20, (int)PLAYER_2_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        else if (player2.getMediumCD()==0) {
            g.drawImage(Assets.ability, (int)PLAYER_2_ABILITIES_X+DEFAULT_ABILITY_WIDTH+20, (int)PLAYER_2_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        if (player2.getFarCD()>0) {
            g.drawImage(Assets.cooldown, (int)PLAYER_2_ABILITIES_X+DEFAULT_ABILITY_WIDTH*2+20*2, (int)PLAYER_2_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
        else if (player2.getFarCD()==0) {
            g.drawImage(Assets.ability, (int)PLAYER_2_ABILITIES_X+DEFAULT_ABILITY_WIDTH*2+20*2, (int)PLAYER_2_ABILITIES_Y,DEFAULT_ABILITY_WIDTH,DEFAULT_ABILITY_HEIGHT, null);
        }
    }
    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
}
