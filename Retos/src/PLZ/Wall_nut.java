/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Graphics2D;

/**
 *
 * @author alanr
 */
public class Wall_nut extends Plant {
    public Wall_nut(juego game, int fila, int columna) {
        super(game, Plant.WALL_NUT, fila, columna);
        vida = 1000;
    }
    public void paint(Graphics2D g) {
        g.drawImage(image, x, y, width, height, game);
    }

    void setFila(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setColumna(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
