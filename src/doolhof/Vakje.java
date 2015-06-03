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
public class Vakje extends SpelElement
{  
    private int x;
    private int y;
    final private int WIDTH = 25;
    final private int HEIGHT = 25;
    
    public Vakje(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void tekenObject(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(x * WIDTH, y * HEIGHT, WIDTH, HEIGHT);
    }
}
