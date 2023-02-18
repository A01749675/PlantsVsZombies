/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author alanr
 */
public class Plant extends Sprite {
    // Constantes de las plantas
    static final int WIDTH = 50;
    static final int HEIGHT = 50;
    static final int PEASHOOTER = 0;
    static final int SUNFLOWER = 1;
    static final int CHERRY_BOMB = 2;
    static final int WALL_NUT = 3;
    static final int PALAYA = 4;
    
    // Variables de la clase Plant
    protected int TIPO_DE_PLANTA;
    protected int fila;
    protected int columna;
    protected int vida;
    protected int timer_habilidad;
    
    public Plant(juego game, int tipo, int fila, int columna) {
        super(game);
        this.TIPO_DE_PLANTA = tipo;
        this.fila = fila;
        this.columna = columna;
        this.x = game.coordX[columna];
        this.y = game.coordY[fila];
        this.width = WIDTH;
        this.height = 55;
        this.class_id = PLANT;
        
        generateImage(getImage(TIPO_DE_PLANTA));
        
    }

    public int getTIPO_DE_PLANTA() {
        return TIPO_DE_PLANTA;
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
    
    private String getImage(int plant_id) {
        String url = "";
        switch(plant_id) {
            case 0:
                url = "peashooter";
                break;
            case 1: 
                url = "sunflower";
                break;
            case 2: 
                url = "cherrybomb";
                break; 
            case 3:
                url = "wall-nut";
                break;
            case 4:
                url = "palaya";
                break;
        }
        return url + ".png";
    }

    public juego getGame() {
        return game;
    }

    public int getTimer_habilidad() {
        return timer_habilidad;
    }

    
    public void paint(Graphics2D g) {
        g.drawImage(image, x, y, width, height, game);
        usarHabilidad(g);
    }
    
    public void usarHabilidad(Graphics2D g) {}
    
    public void damagePlant(int damage) {
        this.vida -= damage;
        if(this.vida <= 0) { 
            visible = false;
            ZombieSounds.GULP.play();
        }
    }
   
   
}