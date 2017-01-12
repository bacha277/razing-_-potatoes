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
    public static Font font=new Font("TimesRoman", Font.PLAIN, 50);
    public static int DEFAULT_ANNOUNCEMENT_X=120;
    public static int DEFAULT_ANNOUNCEMENT_Y=50;
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
    }
    
}
