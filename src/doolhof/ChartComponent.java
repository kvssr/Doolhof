/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Kevin
 */
public class ChartComponent extends JComponent
{
    private Speler s;
    private SpelElement vakje1;
    private SpelElement[][] elementen = new SpelElement[300][300];
    
    @Override
     public void paintComponent(Graphics g)
     {     
        for(int i = 0;i<300;i+=25)
        {
            for(int j = 0;j<300;j+=25)
            {
                SpelElement se = elementen[i][j];
                se.maakVakje(i, j, g);
            }
        }    
     }
    
    public void init()
    {
        for(int i = 0;i<300;i+=25)
        {
            for(int j = 0;j<300;j+=25)
            {
                if(i == 0 || i == 275) {
                    Muur m = new Muur(i,j);
                    elementen[i][j] = m;
                }
                else if(j == 0 || j == 275) {
                    Muur m = new Muur(i,j);
                    elementen[i][j] = m;
                }
                else if(i == 25 && j == 25){
                    s = new Speler(i,j);
                    elementen[i][j] = s;
                }
                else{
                    Vakje v = new Vakje(i,j);
                    elementen[i][j] = v;
                }
            }
        }
    }
    
    public Speler getSpeler()
    {
        System.out.println(s);
        return s;
    }
    
    public SpelElement[][] getElementen()
    {
        return elementen;
    }
    
    public void bewegen(int i)
    {
        int x = s.getX();
        int y = s.getY();
        
        if(i == 1){
            try{
                if(elementen[x][y-25] instanceof Muur){

                }
                else{
                    vakje1 = elementen[x][y-25];
                    elementen[x][y-25] = elementen[x][y];
                    elementen[x][y] = vakje1;
                    s.setCord(x, y-25);                   
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if(i == 2){
            if(elementen[x+25][y] instanceof Muur){

            }
            else{
                vakje1 = elementen[x+25][y];
                elementen[x+25][y] = elementen[x][y];
                elementen[x][y] = vakje1;
                s.setCord(x+25, y);
            }
        }
        if(i == 3){
            if(elementen[x][y+25] instanceof Muur){

            }
            else{
                vakje1 = elementen[x][y+25];
                elementen[x][y+25] = elementen[x][y];
                elementen[x][y] = vakje1;
                s.setCord(x, y+25);
            }
        }
        if(i == 4){
            if(elementen[x-25][y] instanceof Muur){

            }
            else{
                vakje1 = elementen[x-25][y];
                elementen[x-25][y] = elementen[x][y];
                elementen[x][y] = vakje1;
                s.setCord(x-25, y);
            }
        }
    }
}
