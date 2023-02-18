/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author alanr
 */
public class Sprite {
    // IDENTIFICADORES
    public final int PLANT = 0;
    public final int ZOMBIE = 1;
    public final int PROYECTILE = 3;
    public final int SUN = 4;
    
    // Variables de la clase
    protected int class_id;
    protected int x;
    protected int y;
    protected int height;
    protected int width;
    protected boolean visible;
    protected Image image;
    protected juego game;
    
    
    Sprite(juego game) {
        this.visible = true;
        this.game = game;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public juego getGame() {
        return game;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    public void generateImage(String name) {
        try {
            image= new ImageIcon(game.getClass().getResource(name)).getImage();
        } catch (Exception e) {
            System.out.println("Algo pasó mal con la imagen " + name);
        }
    }   
}
