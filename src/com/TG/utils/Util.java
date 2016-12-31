/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TG.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BHT
 */
public class Util {
    public static String loadFileAsString(String path)
    {
        StringBuilder builder=new StringBuilder();
        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            String line;
            while ((line=br.readLine())!=null) {                
                builder.append(line+"\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.toString();
    }
    public static int parseInt(String number)
    {
        return Integer.parseInt(number);
    }
}
