/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author alanr
 */
public class CherryBomb extends Plant {
    
    public CherryBomb(juego game, int fila, int columna) {
        super(game, Plant.CHERRY_BOMB, fila, columna);
        timer_habilidad = 30;
        this.vida = 15000000;
        this.fila = fila;
         
        
    }
    public void usarHabilidad(Graphics2D g) {
        // Checar si hay zombie en los cuadrados 
        for(int i = fila-1; i <=fila+1;i++){
            if(i<0 || i>=game.FILAS) continue;
             for(int j = 0; j<game.zombies.get(i).size();j++){
                System.out.println("i: "+i);
                Zombie z = (Zombie) game.zombies.get(i).get(j);
                System.out.println(z.getFila());
                System.out.println(fila);
                if(z.getBounds().intersects(getBounds())){
                    z.recibirDaño(Integer.MAX_VALUE);
                }
            }
        }
    }
    public void paint(Graphics2D g) {
        timer_habilidad--;
         if(timer_habilidad > 0) {
            if(timer_habilidad > 15) {
                width++;
                height++;
                x--;y--;
            }
            if(timer_habilidad == 15) {
                width *= 2 ;
                height *= 2;
                x -= width/4;
                y -= height/4;
                generateImage("Cherryexplosion.png");
                PlantSounds.BOOM.play();
                usarHabilidad(g);
            }
            g.drawImage(image, x, y, width, height, game);
         }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(game.coordX[columna]-100, game.coordY[fila]-100,300,300);
    }


}
