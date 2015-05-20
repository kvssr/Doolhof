/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Kevin
 */
public class HomeFrame extends JFrame
{
    private JButton button;
    private JPanel panel;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private ChartComponent com;
    
    
    public HomeFrame()
    {   
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        createComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void createComponents()
    {
        button = new JButton("Start!");

        button.setSize(100, 50);
        
        com = new ChartComponent();
        com.setPreferredSize(new Dimension(400, 400));
        
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
        
        panel = new JPanel();
        panel.add(button);
        panel.add(com);
        com.init();
        
        KeyListener klistener = new MyKeyListener();
        panel.addKeyListener(klistener);
        
        this.add(panel);
    
    }
    
    class ClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("Click!");
            panel.requestFocusInWindow();
            com.repaint();
        }
    } 
    
    class MyKeyListener implements KeyListener{
        
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("Key typed: " + e.getKeyChar());
            if(e.getKeyChar() == 'w'){              
                try
                {
                    com.bewegen(1);
                    com.repaint();
                }
                catch(Exception f)
                {
                    System.out.println(f);
                }
                //s.bewegen(1);
            }
            else if(e.getKeyChar() == 'a') {
                com.bewegen(4);
                com.repaint();
            }
            else if(e.getKeyChar() == 's') {
                com.bewegen(3);
                com.repaint();
            }
            else if(e.getKeyChar() == 'd') {
                com.bewegen(2);
                com.repaint();
            }
        }
            @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Key pressed: " + e.getKeyChar());
            
        }

            @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("Key released: " + e.getKeyChar());
        }      
    }    
}
