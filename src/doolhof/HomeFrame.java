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
    private Level2 com2;
    
    public HomeFrame()
    {   
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        createStart();
        this.setLocationRelativeTo(null);
    }
    
    private void createStart()
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
        
        KeyListener klistener = new MyKeyListener();
        panel.addKeyListener(klistener);
        
        this.add(panel);
    }
    
    private void createSecond()
    {
        button = new JButton("Start!");

        button.setSize(100, 50);
        
        com2 = new Level2();
        com.setPreferredSize(new Dimension(400, 400));
          
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
        
        panel = new JPanel();
        panel.add(button);
        panel.add(com);
        
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
            com.repaint();
        }
    } 
    
    class MyKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("Key typed: " + e.getKeyChar());
            
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
    
    public JPanel getPanel()
    {
        return panel;
    }
}
