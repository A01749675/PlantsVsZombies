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
public class Carta {
    int TIPO_DE_PLANTA;
    int precio;
    juego juego;

    public Carta(juego juego, int tipo) {
        this.juego = juego;
        this.TIPO_DE_PLANTA = tipo;
        // this.precio = juego.getPlanta(tipo);
    }
    
    public int getTIPO_DE_PLANTA() {
        return TIPO_DE_PLANTA;
    }

    public int getPrecio() {
        return precio;
    }
    
}
