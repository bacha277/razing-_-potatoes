/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.launch;

import com.TG.display.Display;
import com.TG.gfx.Assets;
import com.TG.input.KeyManager;
import com.TG.states.GameState;
import com.TG.states.State;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BHT
 */
public class Game implements Runnable{
    
    private Display display;
    public String title;
    public int width,height;
    
    private Thread thread;
    private boolean running=false;
    
    private BufferStrategy bs;
    private Graphics g;
    
    private KeyManager keyManager;
//    states
    private State gameState;
    
    public Game(String title,int width,int height) {
        this.title=title;
        this.width=width;
        this.height=height;
        keyManager=new KeyManager();
    }
   
    private void tick()
    {
        keyManager.ticks(); 
        if (State.getState()!=null) {
            State.getState().tick();
        }
    }
    
    private void render()
    {
        bs=display.getCanvas().getBufferStrategy();
        if (bs==null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
//        clear screen
        g.clearRect(0, 0, width, height);
//        draw
        if (State.getState()!=null) {
            State.getState().render(g);
        }
//        end draw
        bs.show();
        g.dispose();
    }
    
    @Override
    public void run() {
        init();
        
        int fps=60;
        double timePerTick = 1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        int ticks=0;
        
        while (running) {
            now=System.nanoTime();
            delta+=(now-lastTime)/timePerTick;
            timer+=now-lastTime;
            lastTime=now;
            
            if (delta>=1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer>=1000000000) {
//                System.out.println("fps:"+ticks);
                ticks=0;
                timer=0;
            }
        }
        stop();
    }
    
    public synchronized void start()
    {
        if (running) {
            return;
        }
        running=true;
        thread=new Thread(this);
        thread.start();
    }
    
    public synchronized void stop()
    {
        if (!running) {
            return;
        }
        running=false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void init() {
        display=new Display(title, height, width);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        gameState=new GameState(this);
        State.setState(gameState);
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    
}
