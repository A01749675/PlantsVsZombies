/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Vector;
import javax.imageio.ImageIO;

/**
 *
 * @author ikerf
 */
public class Sunflower_ghost extends Ghost_Flowers{
    int[] coordX = game.coordX;
    int[] coordY = game.coordY;
    int x = coordX[columna];
    int y = coordY[fila];
    BufferedImage Image;
    public Sunflower_ghost(juego game, int fila, int columna){
        super(game, fila, columna);
        this.game = game;
        this.fila = fila;
        this.columna = columna;
    }

    public void paint(Graphics2D g){
        try {
            Image = ImageIO.read(getClass().getResourceAsStream("sunflower.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        g.drawImage(Image, x, y, WIDTH, HEIGHT, null);
    }    
}
