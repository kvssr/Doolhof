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
    private SpelElement[][] elementen;
    
    public Speler(int x, int y)
    {
        elementen = super.getElementen();
        addSpeler(x,y);
        
    }
    
    public void maakSpeler(int x, int y, Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(x, y, 25, 25);
    }
    
    private void addSpeler(int x, int y)
    {
        elementen[x][y] = this;
    }
    
    public void bewegen(int i)
    {
        if(i ==1){
            
        }
        if(i ==2){
            
        }
        if(i ==3){
            
        }
        if(i ==4){
            
        }
    }
    
}
