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
public class Periodico extends Zombie {
    private final int VIDA_PERIODICO = 160;
    private final int VIDA_SIN_PERIODICO = 200;
    private boolean ya_me_enoje = false;
    
    public Periodico(juego game, int fila) {
        super(game, Zombie.ZOMBI_PERIODICO, fila);
        vida = VIDA_SIN_PERIODICO +VIDA_PERIODICO;
    }
    
    @Override
    public void recibirDaño(int daño) {
        this.vida -= daño;
        if (ya_me_enoje==false){
            ya_me_enoje=periodico_enojado();
        }
        if(this.vida <= 0) visible = false;
    }
    
    public boolean periodico_enojado(){
        if(vida <= VIDA_SIN_PERIODICO) {
            generateImage("periodico_enojado.png");
            ZombieSounds.NPANGRY.play();
            this.setVelocidad(4);
            return true;
        }
        else{return false;}
    }
}