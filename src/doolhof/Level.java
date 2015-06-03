/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JComponent;

/**
 *
 * 
 */
public class Level extends JComponent
{
    private Speler s;
    private int stappen = 0;
    private SpelElement[][] elementen = new SpelElement[12][12];
    private int currentLevel;
    private boolean heeftBazooka = false;
    
    /**
     * paintComponent - tekent alle objecten uit de array.
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
                se.tekenObject(g);
            }
        }
        g.setColor(Color.white);
        g.drawString("Stappen: "+stappen, 0, 10);
        g.drawString("Bazooka: "+ heeftBazooka, 80, 10);
        s.tekenObject(g);
     }
    
    /**
     * laadLevel - vuld de array met alle objecten.
     */
    public void laadLevel(int levelNr)
    {
        currentLevel = levelNr;
        try
        {
            Scanner in = new Scanner(new File("src/doolhof/level" + levelNr + ".txt").getAbsoluteFile());
            for(int i = 0;i<12;i++)
            {
                char[] lijst;
                String s1 = in.nextLine();
                lijst = s1.toCharArray();
                
                for(int j = 0;j<12;j++){
                    
                    char c = lijst[j];
                    switch(c){
                        case 'm':
                            Muur m = new Muur(j,i);
                            elementen[j][i] = m;
                            break;
                        case 's':
                            Vakje v = new Vakje(j,i);
                            s = new Speler(j,i);
                            elementen[j][i] = v;
                            break;
                        case 'v':
                            v = new Vakje(j,i);
                            elementen[j][i] = v;
                            break;
                        case 'd':
                            Vriend d = new Vriend(j,i);
                            elementen[j][i] = d;
                            break;
                        case 'c':
                            Valsspeler vals = new Valsspeler(j,i);
                            elementen[j][i] = vals;
                            break;
                        case 'b':
                            Bazooka b = new Bazooka(j,i);
                            elementen[j][i] = b;
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println(e);
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
            else if(elementen[x][y-1] instanceof Vriend){
                this.laadLevel(currentLevel + 1);
                this.repaint();
                stappen = 0;
                heeftBazooka = false;
            }
            else if(elementen[x][y-1] instanceof Valsspeler){
                stappen -= 4;
                Vakje vc = new Vakje(x,y-1);
                elementen[x][y-1] = vc;
                s.setY(y-1);
                s.setRichting(1);
            }
            else {
                s.setY(y-1);
                s.setRichting(1);
                stappen ++;
            }
        }
        else if(i == 2){
            if(elementen[x+1][y] instanceof Muur){

            }
            else if(elementen[x+1][y] instanceof Vriend){
                this.laadLevel(currentLevel + 1);
                this.repaint();
                stappen = 0;
                heeftBazooka = false;
            }
            else if(elementen[x+1][y] instanceof Valsspeler){
                stappen -= 4;
                Vakje vc = new Vakje(x+1,y);
                elementen[x+1][y] = vc;
                s.setX(x+1); 
                s.setRichting(2);
            }
            else{
                s.setX(x+1);
                stappen ++;
                s.setRichting(2);
            }
        }
        else if(i == 3){
            if(elementen[x][y+1] instanceof Muur){

            }
            else if(elementen[x][y+1] instanceof Vriend){
                this.laadLevel(currentLevel + 1);
                this.repaint();
                stappen = 0;
                heeftBazooka = false;
            }
            else if(elementen[x][y+1] instanceof Valsspeler){
                stappen -= 4;
                Vakje vc = new Vakje(x,y+1);
                elementen[x][y+1] = vc;
                s.setY(y+1);
                s.setRichting(3);
            }
            else{
                s.setY(y+1);
                stappen ++;
                s.setRichting(3);
            }
        }
        else if(i == 4){
            if(elementen[x-1][y] instanceof Muur){

            }
            else if(elementen[x-1][y] instanceof Vriend){
                this.laadLevel(currentLevel + 1);
                this.repaint();
                stappen = 0;
                heeftBazooka = false;
            }
            else if(elementen[x-1][y] instanceof Valsspeler){
                stappen -= 4;
                Vakje vc = new Vakje(x-1,y);
                elementen[x-1][y] = vc;
                s.setX(x-1);
                s.setRichting(4);
            }
            else{
                s.setX(x-1);
                stappen ++;
                s.setRichting(4);
            }
        }
        else if(i == 5){
            if(elementen[x][y] instanceof Bazooka && heeftBazooka == false){
                heeftBazooka = true;
                Vakje vn = new Vakje(x,y);
                elementen[x][y] = vn;
            }
            else{
                System.out.println("Er is hier geen bazooka");
            }
        }
        else if(i == 6){
            schieten(x,y);
        }
    }
    
    public void schieten(int x, int y)
    {
        if(heeftBazooka == true){
                int teller = 1;
                Vakje vn = new Vakje(x,y);
                int richting = s.getRichting();
                switch(richting)
                {
                    case 1:
                        while(heeftBazooka){
                            if(elementen[x][y-teller] instanceof Muur)
                            {
                                elementen[x][y-teller] = vn;
                                heeftBazooka = false;
                            }
                            teller++;
                        }
                        break;
                    case 2:
                        while(heeftBazooka){
                            if(elementen[x+teller][y] instanceof Muur)
                            {
                                elementen[x+teller][y] = vn;
                                heeftBazooka = false;
                            }
                            teller++;
                        }
                        break;
                    case 3:
                        while(heeftBazooka){
                            if(elementen[x][y+teller] instanceof Muur)
                            {
                                elementen[x][y+teller] = vn;
                                heeftBazooka = false;
                            }
                            teller++;
                        }
                        break;
                    case 4:
                        while(heeftBazooka){
                            if(elementen[x-teller][y] instanceof Muur)
                            {
                                elementen[x-teller][y] = vn;
                                heeftBazooka = false;
                            }
                            teller++;
                        }
                        break;
                }
            }
            else{
                System.out.println("Je Hebt geen bazooka!");
            }
    }
    
    public int getCurrentLevel()
    {
        return currentLevel;
    }
    
    public void resetStappen()
    {
        stappen = 0;
    }
}
