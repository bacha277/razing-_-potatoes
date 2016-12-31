/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.states;

import com.TG.launch.Game;
import java.awt.Graphics;

/**
 *
 * @author BHT
 */
public abstract class State {
    private static State currentState=null;
    private Game game;
    
    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    public State(Game game) {
        this.game = game;
    }
    
    
    
    public abstract void tick();
    public abstract void render(Graphics g);
}
