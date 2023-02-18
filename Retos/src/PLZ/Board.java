/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author ikerf
 */
public class Board{
    BufferedImage image;
    BufferedImage image2;
    BufferedImage image3;
    BufferedImage image4;
    BufferedImage image5;
    BufferedImage floor; 
    BufferedImage grass;
    public int coordX[] = {25, 125, 225,325,425,525,625,725,825,925,1025};
    public int coordY[] = {25, 125, 225,325,425,525,625};
    private juego game;
    public Board(juego game){
        this.game = game;
    }
    public void paint(Graphics2D g){        
        int y = 0;
        int j = 0;
        int start = 300;
        for(int i = 0; i<game.FILAS; i++){
            int x = 0;
            for(int h = 0; h<game.COLUMNAS; h++){
                if(x==0){
                    g.setColor(Color.black);
                    g.fillRect(x, y, 100, 100);
                    g.setColor(Color.red);
                    try {
                        floor = ImageIO.read(getClass().getResourceAsStream("floor.png"));
                    } catch (Exception e) {
                           e.printStackTrace();
                    }
                    g.drawImage(floor,x,y,100,100,null);
                    g.drawString(String.valueOf(j), x+50, y+50);
                 }
                 else{
                    g.setColor(Color.black);
                    g.drawRect(x, y, 100, 100);  
                    g.drawString(String.valueOf(j), x+50, y+50);
                 }
                 x+= 100;
                 j++;
            }
            y+=100;   
    }
        for(int i = 0; i<6; i++){
            g.setColor(Color.black);
            g.fillRect(start,600,100,100);
            g.setColor(Color.green);
            g.drawRect(start,600,100,100);
            start+=100;
        }
        
        g.setColor(Color.green);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g.drawString("PLANTAS", 320, 650);
        g.drawString("SUNFLOWER", 405, 700);
        g.drawString("PEASHOOTER", 505, 700);
        g.drawString("NUT",640,700);
        g.drawString("Palaya", 735, 700);
        g.drawString("CHERRY", 835, 700);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("sunflower.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        g.drawImage(image, 425, 625, 50, 50, null);

        try {
            image2 = ImageIO.read(getClass().getResourceAsStream("peashooter.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(image2, 525, 625, 50, 50, null);
        try {
            image3 = ImageIO.read(getClass().getResourceAsStream("wall-nut.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(image3, 625, 625, 50, 50, null);
        try {
            image4 = ImageIO.read(getClass().getResourceAsStream("palaya.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(image4, 725, 625, 50, 50, null);
        try {
            image5 = ImageIO.read(getClass().getResourceAsStream("cherrybomb.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(image5,825,625,50,50,null);
        
    }
}
