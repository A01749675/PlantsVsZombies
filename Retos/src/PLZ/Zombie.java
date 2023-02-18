/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Graphics2D;
import static java.lang.Float.max;
import static java.lang.Float.min;
import java.util.concurrent.ThreadLocalRandom;

public class Zombie extends Sprite {
    // Constantes de los Zombies
    static final int WIDTH = 55;
    static final int HEIGHT = 63;
    static final int DAÑO = 10;
    static final int VELOCIDAD_MOVIMIENTO = 2;
    static final int VELOCIDAD_ATAQUE = 10;
    static final int VELOCIDAD_GRUÑIDO = 80;
    static final int ZOMBI_COMUN = 0;
    static final int ZOMBI_CONO = 1;
    static final int ZOMBI_CUBO = 2;
    static final int ZOMBI_PERIODICO = 3;
    static final int ZOMBI_AMERICANO = 4;
    
    // Variables de la Clase Zombie
    protected int TIPO_DE_ZOMBIE;
    protected int fila;
    protected int columna;
    protected int vida;
    protected int timer_ataque;
    protected int timer_gruñido;
    protected boolean atacando;
    public int velocidad;
    protected boolean chomp1 = true;
    public boolean ralentizado;
    public boolean te_comi_los_sesos = false;
    
    public Zombie(juego game, int tipo, int fila) {
        super(game);
        this.TIPO_DE_ZOMBIE = tipo;
        this.fila = fila;
        this.x = 1025;
        this.y = game.coordY[fila];
        this.velocidad = VELOCIDAD_MOVIMIENTO;
        this.atacando = false;
        this.ralentizado = false;
        this.timer_ataque = VELOCIDAD_ATAQUE;
        this.timer_gruñido = VELOCIDAD_GRUÑIDO;
        this.width = WIDTH;
        this.height = HEIGHT;
        this.class_id = ZOMBIE;
        
        generateImage(getImage(TIPO_DE_ZOMBIE));
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTIPO_DE_ZOMBIE() {
        return TIPO_DE_ZOMBIE;
    }

    public int getFila() {
        return fila;
    }
 
    public int getColumna() {
        return columna;
    }

    public int getVida() {
        return vida;
    }

    public juego getGame() {
        return game;
    }

    public int getTimer_ataque() {
        return timer_ataque;
    }

    public boolean isTe_comi_los_sesos() {
        return te_comi_los_sesos;
    }

    public void setTe_comi_los_sesos(boolean te_comi_los_sesos) {
        this.te_comi_los_sesos = te_comi_los_sesos;
    }
    

    private String getImage(int plant_id) {
        String url = "";
        switch(plant_id) {
            case 0:
                url = "comun";
                break;
            case 1: 
                url = "cono";
                break;
            case 2: 
                url = "cubo";
                break; 
            case 3:
                url ="periodico";
                break;
            case 4:
                url ="football";
                break;
        }
        return url + ".png";
    }
    
    public void paint(Graphics2D g) {
        // Checa si hay una colisión con una planta
        //Plant p = collision();
        Plant p = check_collision();
        if(p == null) {
            this.atacando = false;
        } else this.atacando = true;
        
        if(!this.atacando) { 
            move(); 
        }
        else {
            atacar(p);
        }
        
        g.drawImage(image, x, y, width, height, game);
    }
    
    void move() {
        this.x += -velocidad;
    }

    private Plant check_collision() {
        for(int c = 0; c < game.COLUMNAS; c++) {
            Plant p = game.plants[this.fila][c];
            if(p != null && p.getBounds().intersects(this.getBounds())) {
                return p;
            }
        }
        return null;
    }
    
    private void atacar(Plant p) {
        timer_ataque--;
        if(this.timer_ataque == 0) {
            p.damagePlant(DAÑO);
            this.timer_ataque = VELOCIDAD_ATAQUE;
            
            // Hace sonidos que come de la clase ZombieSounds
            if(chomp1) {
                ZombieSounds.CHOMP1.play();
                chomp1 = false;
            } else {
                ZombieSounds.CHOMP2.play();
                chomp1 = true;
            }
        }
        
    }
    
    public void recibirDaño(int daño) {
        this.vida -= daño;
        if(this.vida <= 0) visible = false;
    }
    
    public static void gruñir() {
        int randomNum = ThreadLocalRandom.current().nextInt(0,  6) + 1;
        switch(randomNum) {
            case 1:
                ZombieSounds.GROAN1.play();
                break;
            case 2:
                ZombieSounds.GROAN2.play();
                break;
            case 3:
                ZombieSounds.GROAN3.play();
                break;
            case 4:
                ZombieSounds.GROAN4.play();
                break;
            case 5:
                ZombieSounds.GROAN5.play();
                break;
            case 6:
                ZombieSounds.GROAN6.play();
                break;
        }
    }
    
    public void ralentizar(){
        if(!ralentizado){
        this.setVelocidad(velocidad/2);
        this.ralentizado=true;
        }
    }
   
   
}
