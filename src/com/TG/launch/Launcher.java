/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.launch;

import com.TG.display.Display;

/**
 *
 * @author BHT
 */
public class Launcher {
    public static final int DEFAULT_WINDOW_WIDTH=480;
    public static final int DEFAULT_WINDOW_HEIGHT=640;
    public static void main(String[] args) {       
        Game game = new Game("razing-_-potatoes", 480, 640);
        game.start();
    }
}
