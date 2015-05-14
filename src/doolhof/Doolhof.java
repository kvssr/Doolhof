/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kevin
 */
public class Doolhof
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        HomeFrame homeframe = new HomeFrame();
        homeframe.setVisible(true);
        JPanel panel = homeframe.getPanel();
        panel.requestFocusInWindow();     
    }
}
