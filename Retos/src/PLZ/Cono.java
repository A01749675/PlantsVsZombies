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
public class Cono extends Zombie {
    
    public Cono(juego game, int fila) {
        super(game, Zombie.ZOMBI_CONO, fila);
        vida = 640;
    }
    public void recibirDaño(int daño) {
        ZombieSounds.CONE_HIT.play();
        this.vida -= daño;
        if(this.vida <= 0) visible = false;
    }
}
