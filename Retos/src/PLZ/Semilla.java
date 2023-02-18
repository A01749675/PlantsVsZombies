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
public class Semilla extends Sprite {
    static final int GAME_WIDTH = 1000;
    private final int SIZE = 20;
    private int xa = 10;
    private int damage = 50;
    private int fila;
    
    public Semilla (juego game, int x, int y, int fila) {
        super(game);
        this.x = x;
        this.y = y;
        this.width = SIZE;
        this.height = SIZE;
        this.fila = fila;
        this.class_id = PROYECTILE;
        generateImage("seed1.png");
    }
    public int getDamage() {
        return damage;
    }
    public void move() {
        x += xa;
    }
    
    public void paint(Graphics2D g) {
        Zombie z = collision();
        if(z == null) {
            move();   
            if (this.x > GAME_WIDTH) this.visible = false;
        } else {
            PlantSounds.SPLAT.play();
            this.visible = false;
            z.recibirDaño(damage);
            z.ralentizar();
        }
        
        g.drawImage(image, x, y, width, height, game);
    }
    
    private Zombie collision() {
        for(int i = 0; i < game.zombies.get(fila).size(); i++) {
            Zombie z = game.zombies.get(fila).get(i);
            if(z.getBounds().intersects(getBounds())){ 
                return z;
            }
        }
        return null;
    }
    
}
