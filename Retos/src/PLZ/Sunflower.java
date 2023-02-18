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
public class Sunflower extends Plant {
    //Constante de periodo de producción de soles
    private final int PERIODO = 200;
    ArrayList<Sun> suns;
    public boolean skill = false;
    
    public Sunflower(juego game, int fila, int columna) {
        super(game, Plant.SUNFLOWER, fila, columna);
        timer_habilidad = PERIODO;
        vida = 100;
        suns = new ArrayList<>();
    }
    
    public void usarHabilidad(Graphics2D g) {
        // Saca un sol
        timer_habilidad--;
        if(timer_habilidad == (PERIODO/2)) {
            Sun s = new Sun(game, x, y, true);
            suns.add(s);
        }
        if(timer_habilidad <= 0) timer_habilidad = PERIODO;
        updateSuns(g); 
    }
    public void updateSuns(Graphics2D g) {
        for(int i = 0; i < suns.size(); i++) {
            Sun s = suns.get(i);
            if(s.isVisible()) {
                s.paint(g);
                skill = true;
            } else {
                suns.remove(i);
                skill = false;
            }
        }
    }

    public void setFila(int i) {
        this.fila = i;
    }

    public void setColumna(int i) {
        this.columna = i;
    }

    public boolean isSkill() {
        return skill;
    }

    public void setSkill(boolean skill) {
        this.skill = skill;
    }
    
    
}