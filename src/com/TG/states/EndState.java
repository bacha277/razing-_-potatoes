/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.states;

import com.TG.launch.Game;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author BHT
 */
public class EndState extends State{
    public static final Font font=new Font("TimesRoman", Font.PLAIN, 40);
    public static final int DEFAULT_ANNOUNCEMENT_X=140;
    public static final int DEFAULT_ANNOUNCEMENT_Y=50;
    public static final int DEFAULT_REMATCH_X=50;
    public static final int DEFAULT_REMATCH_Y=200;
    
    private Game game;
    private int winner;

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }
    
    public EndState(Game game) {
        super(game);
        this.game=game;
    }

    @Override
    public void tick() {
        getInput();
    }

    @Override
    public void render(Graphics g) {
        g.setFont(font);
        if (winner==2) {
            g.drawString("Red wins !", DEFAULT_ANNOUNCEMENT_X, DEFAULT_ANNOUNCEMENT_Y);
        }
        else if (winner==1) {
            g.drawString("Blue wins !", DEFAULT_ANNOUNCEMENT_X, DEFAULT_ANNOUNCEMENT_Y);
        }
        g.drawString("Press Enter to rematch.", DEFAULT_REMATCH_X, DEFAULT_REMATCH_Y);
    }
    private void getInput()
    {
        if (game.getKeyManager().enter) {
            State.setState(new GameState(game));
        }
    }
}
