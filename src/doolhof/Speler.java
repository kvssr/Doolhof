/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * 
 */
public class Speler extends SpelElement
{
    private int x;
    private int y;
    final private int WIDTH = 25;
    final private int HEIGHT = 25;
    private int richting;
    
    public Speler(int x, int y)
    {
        this.x = x;
        this.y = y;
        richting = 3;
    }

    @Override
    public void tekenObject(Graphics g)
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("images/player.png"));
            g.drawImage(img, x * WIDTH, y * HEIGHT, null);
            } 
        catch (IOException e) {
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
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public void setRichting(int r)
    {
        this.richting = r;
    }
    
    public int getRichting()
    {
        return richting;
    }
}
