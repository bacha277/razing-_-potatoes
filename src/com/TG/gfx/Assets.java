/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author BHT
 */
public class Assets {
    public static BufferedImage dirt,fire,grass,stone,water,sf,sf2,ability,cooldown;
//    private static final int width=32,height=32;
    public static void init()
    {
        SpriteSheet groundsheet=new SpriteSheet(ImageLoader.loadImage("/textures/groundSheet.png"));
        SpriteSheet fiendSheet=new SpriteSheet(ImageLoader.loadImage("/textures/fiendSheet.png"));
        SpriteSheet fireSheet=new SpriteSheet(ImageLoader.loadImage("/textures/fireSheet.png"));
        SpriteSheet waterSheet=new SpriteSheet(ImageLoader.loadImage("/textures/waterSheet.png"));
        SpriteSheet iconSheet=new SpriteSheet(ImageLoader.loadImage("/textures/iconSheet.png"));
        
        dirt=groundsheet.crop(33, 264, 32, 34);
        fire=fireSheet.crop(251, 99, 22, 35);
        grass=groundsheet.crop(726, 330, 32, 34);
        stone=groundsheet.crop(396, 198, 32, 34);
        water=waterSheet.crop(285, 80, 20, 20);
        sf=fiendSheet.crop(20,27,48,52);
        sf2=fiendSheet.crop(380,27,48,52);
        cooldown=iconSheet.crop(189,38,25,18); 
        ability=iconSheet.crop(84,95,25,18); 
    }
}
