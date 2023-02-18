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
public class Sun extends Sprite {
    // Velocidad de movimeinto
    private final int VELOCIDAD_X = 1;
    private final int VELOCIDAD_Y = 2;

    private int size = 50;
    private int ya;
    private int xa;
    private int going_up_timer = 20;
    private int existence_timer = 150;
    private boolean has_sunflower;
    
    public Sun(juego game, int x, int y, boolean has_sf) {
        super(game);
        this.x = x;
        this.y = y;
        this.has_sunflower = has_sf;
        if(has_sunflower) {
            this.ya = -VELOCIDAD_Y;
            this.xa = VELOCIDAD_X;
        } else {
            this.ya = VELOCIDAD_Y;
        }
        this.class_id = SUN;
        generateImage("sun.png");
    }
    
    public void paint(Graphics2D g) {
        --existence_timer;
        if(existence_timer <= 0) visible = false;
        move();
        g.drawImage(image, x, y, size, size, game);
    }
    
    public void move() {
        y += ya;
        if(has_sunflower) {
            x += xa;
            --going_up_timer;
 
            if (going_up_timer <= 0) {
                ya = 0;
                xa = 0;
            } else if(going_up_timer <= 15) {
                ya = VELOCIDAD_Y; 
            }
        }
    }
    public void giveSun() {
        // suncounter += 100;
    }
}
