/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * 
 */
public class Muur extends SpelElement
{    
    private int x;
    private int y;
    final private int WIDTH = 25;
    final private int HEIGHT = 25;
    
    public Muur(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void tekenObject(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(x * WIDTH, y * HEIGHT, WIDTH, HEIGHT);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("images/pyramide.png"));
            g.drawImage(img, x * WIDTH, y * HEIGHT, WIDTH, HEIGHT, null);
            } 
        catch (IOException e) {
            }
        
    }   
}
