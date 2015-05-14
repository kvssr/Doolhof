/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author Kevin
 */
public class ChartComponent extends JComponent
{

    @Override
     public void paintComponent(Graphics g)
     {     
        g.setColor(Color.black);
        for(int i = 0;i<300;i+=25)
        {
            for(int j = 0;j<300;j+=25)
            {
                if(i == 0 || i == 275) {
                    Muur m = new Muur(i,j);
                    m.maakMuur(i, j, g);
                }
                if(j == 0 || j == 275) {
                    Muur m = new Muur(i,j);
                    m.maakMuur(i, j, g);
                }    
                //g.drawRect(i, j, 25, 25);
            }
        }

        Speler s = new Speler(25,25);
        s.maakSpeler(25, 25, g); 
        
        ActionListener listener = new ClickListener();
        //s.addActionListener(listener);
     }
    
    class ClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("Click!");
        }
    }
    
    class PlayerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("Click!");
        }
    }
    
    

}
