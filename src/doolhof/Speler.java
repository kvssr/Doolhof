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
public class Speler extends SpelElement
{
    private int x;
    private int y;
    
    public Speler(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void tekenObject(int x, int y, Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(x, y, 25, 25);
        g.setColor(Color.black);
        g.drawString("S", x+10, y+15);
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setCord(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
