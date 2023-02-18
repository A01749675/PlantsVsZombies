/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

/**
 *
 * @author alanr
 */
public class Football extends Zombie {
    
    public Football(juego game, int fila) {
        super(game, Zombie.ZOMBI_AMERICANO, fila);
        vida = 1700;
        velocidad = 3;
    }
}
