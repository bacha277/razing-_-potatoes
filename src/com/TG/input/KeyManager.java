/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.input;

import com.TG.entities.creatures.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author BHT
 */
public class KeyManager implements KeyListener{
    private boolean[] keys;
    public boolean up,down,right,left,near,medium,far,up2,down2,right2,left2,near2,medium2,far2;
    
    public void ticks()
    {
        up=keys[KeyEvent.VK_UP];
        down=keys[KeyEvent.VK_DOWN];
        left=keys[KeyEvent.VK_LEFT];
        right=keys[KeyEvent.VK_RIGHT];
        up2=keys[KeyEvent.VK_NUMPAD8];
        down2=keys[KeyEvent.VK_NUMPAD5];
        left2=keys[KeyEvent.VK_NUMPAD4];
        right2=keys[KeyEvent.VK_NUMPAD6];
    }
    
    public KeyManager() {
        keys=new boolean[256];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
    
}
