/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * 
 */
abstract public class SpelElement
{ 
    private int x;
    private int y;
    final private int WIDTH = 25;
    final private int HEIGHT = 25;
    
    public void tekenObject(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }             
}
