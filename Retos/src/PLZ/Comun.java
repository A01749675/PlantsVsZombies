/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Graphics2D;

/**
 *
 * @author Aramaru
 */
public class Comun extends Zombie {
    
    public Comun(juego game, int fila) {
        super(game, Zombie.ZOMBI_COMUN, fila);
        vida = 270;
    }
}
