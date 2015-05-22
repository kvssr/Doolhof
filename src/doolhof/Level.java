/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author Kevin
 */
public class Level extends JComponent
{
    private Speler s;
    private SpelElement vakje1;
    private SpelElement[][] elementen = new SpelElement[12][12];
    
    /**
     * paintComponent - tekend alle objecten uit de array.
     * @param g 
     */
    @Override
     public void paintComponent(Graphics g)
     {     
        for(int i = 0;i<12;i++)
        {
            for(int j = 0;j<12;j++)
            {
                SpelElement se = elementen[i][j];
                se.maakVakje(i * 25, j * 25, g);
            }
        }    
     }
    
    /**
     * init - vuld de array met alle objecten.
     */
    public void init()
    {
        try
        {
            Scanner in = new Scanner(new File("src/doolhof/level2.txt").getAbsoluteFile());
            for(int i = 0;i<12;i++)
            {
                char[] lijst;
                String s1 = in.nextLine();
                lijst = s1.toCharArray();
                
                for(int j = 0;j<12;j++){
                    
                    char c = lijst[j];
                    System.out.println(c);
                    switch(c){
                        case 'm':
                            Muur m = new Muur(j,i);
                            elementen[j][i] = m;
                            break;
                        case 's':
                            s = new Speler(j,i);
                            elementen[j][i] = s;
                            break;
                        case 'v':
                            Vakje v = new Vakje(j,i);
                            elementen[j][i] = v;
                            break;
                    }
                }
            }
        } catch (FileNotFoundException ex)
        {
            
        }
    }
          
    /**
     * bewegen - beweegt het speler object.
     * @param i 
     */
    public void bewegen(int i)
    {
        int x = s.getX();
        int y = s.getY();
        
        if(i == 1){
            if(elementen[x][y-1] instanceof Muur){

            }
            else{
                vakje1 = elementen[x][y-1];
                elementen[x][y-1] = elementen[x][y];
                elementen[x][y] = vakje1;
                s.setCord(x, y-1);                   
            }
        }
        if(i == 2){
            if(elementen[x+1][y] instanceof Muur){

            }
            else{
                vakje1 = elementen[x+1][y];
                elementen[x+1][y] = elementen[x][y];
                elementen[x][y] = vakje1;
                s.setCord(x+1, y);
            }
        }
        if(i == 3){
            if(elementen[x][y+1] instanceof Muur){

            }
            else{
                vakje1 = elementen[x][y+1];
                elementen[x][y+1] = elementen[x][y];
                elementen[x][y] = vakje1;
                s.setCord(x, y+1);
            }
        }
        if(i == 4){
            if(elementen[x-1][y] instanceof Muur){

            }
            else{
                vakje1 = elementen[x-1][y];
                elementen[x-1][y] = elementen[x][y];
                elementen[x][y] = vakje1;
                s.setCord(x-1, y);
            }
        }
    }
}
