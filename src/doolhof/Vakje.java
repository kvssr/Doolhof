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
public class Vakje extends SpelElement
{
    private SpelElement[][] elementen;
    private int x;
    private int y;
    
    public Vakje(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void maakVakje(int x, int y, Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(x, y, 25, 25);
    }
    
    private void addVakje(int x, int y)
    {
        elementen[x][y] = this;
    }
}
