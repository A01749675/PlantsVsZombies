/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author alanr
 */
public class Palaya extends Plant {
    private final int FIRE_RATE = 30;
    ArrayList<Semilla> semillas;
    
    public Palaya(juego game, int fila, int columna) {
        super(game, Plant.PALAYA, fila, columna);
        this.timer_habilidad = 0;
        this.vida = 100;
        semillas = new ArrayList<>();
    }
    
    public void usarHabilidad(Graphics2D g) {
        if(game.zombies.get(fila).size() > 0) {
            timer_habilidad--;
            if(timer_habilidad <= 0) {
                Semilla s = new Semilla(getGame(), getX()+(getWidth()/2), getY()+(getHeight()/3), getFila());
                semillas.add(s);
                timer_habilidad = FIRE_RATE;
                PlantSounds.THROW.play();
            }
        } else timer_habilidad = FIRE_RATE;
        updateSemillas(g);
    }
    private void updateSemillas(Graphics2D g) {
        for(int i = 0; i < semillas.size(); i++) {
            Semilla sem = semillas.get(i);
            if(sem.isVisible()) {
                sem.paint(g);
            } else {
                semillas.remove(i);
            }
        }
        
    }

    void setFila(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setColumna(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
