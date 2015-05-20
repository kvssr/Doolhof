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
    private int x;
    private int y;
    
    public Speler(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void maakVakje(int x, int y, Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(x, y, 25, 25);
    }
    
    public void addSpeler(Speler s)
    {
        elementen[x][y] = s;      
    }
    
    public void bewegen(int i)
    {
        if(i == 1){
            try{
            elementen[x][y+1] = elementen[x][y];
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if(i == 2){
            elementen[x+1][y] = elementen[x][y];
        }
        if(i == 3){
            elementen[x][y+1] = elementen[x][y];
        }
        if(i == 4){
            elementen[x-1][y] = elementen[x][y];
        }
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
