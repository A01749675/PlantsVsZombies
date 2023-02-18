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
public class Cubo extends Zombie {
    
    public Cubo(juego game, int fila) {
        super(game, Zombie.ZOMBI_CUBO, fila);
        vida = 1370;
    }
    public void recibirDaño(int daño) {
        ZombieSounds.CUBE_HIT.play();
        this.vida -= daño;
        if(this.vida <= 0) visible = false;
    }
}
