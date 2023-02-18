/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

/**
 *
 * @author ikerf
 */
public class Ghost_Flowers{
    static final int WIDTH = 50;
    static final int HEIGHT = 50;
    protected int fila;
    protected int columna;
    protected int x;
    protected int y;
    protected juego game;
    public Ghost_Flowers(juego game, int fila,  int columna){
       this.game = game;
       this.fila = fila;
       this.columna = columna;
       
    }
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
