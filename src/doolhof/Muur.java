/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Kevin
 */
public class Muur extends SpelElement
{
    private int x;
    private int y;
    
    public Muur(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void tekenObject(int x, int y, Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(x, y, 25, 25);
    }   
}
