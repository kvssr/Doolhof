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
abstract public class SpelElement
{ 
    public void maakVakje(int x, int y, Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(x, y, 25, 25);
    }             
}
