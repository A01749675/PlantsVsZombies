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
public class Peashooter extends Plant {
    private final int FIRE_RATE = 30;
    ArrayList<Pea> peas;
    
    public Peashooter(juego game, int fila, int columna) {
        super(game, Plant.PEASHOOTER, fila, columna);
        this.timer_habilidad = 0;
        this.vida = 100;
        peas = new ArrayList<>();
    }
    
    public void usarHabilidad(Graphics2D g) {
        if(game.zombies.get(fila).size() > 0) {
            timer_habilidad--;
            if(timer_habilidad <= 0) {
                Pea p = new Pea(getGame(), getX()+(getWidth()/2), getY()+(getHeight()/3), getFila());
                peas.add(p);
                timer_habilidad = FIRE_RATE;
                PlantSounds.THROW.play();
            }
        } else timer_habilidad = FIRE_RATE;
        updatePeas(g);
    }
    private void updatePeas(Graphics2D g) {
        for(int i = 0; i < peas.size(); i++) {
            Pea p = peas.get(i);
            if(p.isVisible()) {
                p.paint(g);
            } else {
                peas.remove(i);
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
