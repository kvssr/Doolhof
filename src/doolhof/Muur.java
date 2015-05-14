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
    private SpelElement[][] elementen;
    
    public Muur(int x, int y)
    {
        elementen = super.getElementen();
        addMuur(x,y);       
    }
    
    public void maakMuur(int x, int y, Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(x, y, 25, 25);
    }
    
    private void addMuur(int x, int y)
    {
        elementen[x][y] = this;
    }
    
}
