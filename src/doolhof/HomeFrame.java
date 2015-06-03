/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * 
 */
public class HomeFrame extends JFrame
{
    private JButton button;
    private JPanel panel;
    private static final int FRAME_WIDTH = 320;
    private static final int FRAME_HEIGHT = 400;
    private Level Level;
    
    
    public HomeFrame()
    {   
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        createComponents();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * createComponents - Maakt het paneel en de knoppen.
     */
    private void createComponents()
    {
        button = new JButton("Start!");
        
        Level = new Level();
        Level.setPreferredSize(new Dimension(300, 300));
        
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
        button.setPreferredSize(new Dimension(100, 50));
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout(100,100));
        panel.add(button, BorderLayout.SOUTH);
        panel.add(Level, BorderLayout.NORTH);
        Level.laadLevel(1);
        
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
            button.setText("Reset");
            panel.requestFocusInWindow();
            int currentLevel = Level.getCurrentLevel();
            Level.laadLevel(currentLevel);
            Level.resetStappen();
            Level.repaint();
        }
    } 
    
    class MyKeyListener implements KeyListener{
        
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("Key typed: " + e.getKeyChar());
            if(e.getKeyChar() == 'w'){              
                Level.bewegen(1);
                Level.repaint();
            }
            else if(e.getKeyChar() == 'a') {
                Level.bewegen(4);
                Level.repaint();
            }
            else if(e.getKeyChar() == 's') {
                Level.bewegen(3);
                Level.repaint();
            }
            else if(e.getKeyChar() == 'd') {
                Level.bewegen(2);
                Level.repaint();
            }
            else if(e.getKeyChar() == 'e') {
                Level.bewegen(5);
                Level.repaint();
            }
            else if(e.getKeyChar() == 'f') {
                Level.bewegen(6);
                Level.repaint();
            }
        }
            @Override
        public void keyPressed(KeyEvent e) {     
        }

            @Override
        public void keyReleased(KeyEvent e) {     
        }      
    }    
}
