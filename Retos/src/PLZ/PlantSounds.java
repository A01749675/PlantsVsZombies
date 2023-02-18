/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 *
 * @author alanr
 */
public class PlantSounds {
    // PLANTAS EN GENERAL
    public static final AudioClip PLANT = Applet.newAudioClip(PlantSounds.class.getResource("./PlantSounds/plant.wav"));
    
    //SUNFLOWER
    public static final AudioClip PICK_SUN = Applet.newAudioClip(PlantSounds.class.getResource("./PlantSounds/points.wav"));
    
    //PEASHOOTER
    public static final AudioClip THROW = Applet.newAudioClip(PlantSounds.class.getResource("./PlantSounds/throw.wav"));
    public static final AudioClip SPLAT = Applet.newAudioClip(PlantSounds.class.getResource("./PlantSounds/splat.wav"));
    
    //CHERRY BOMB
    public static final AudioClip BOOM = Applet.newAudioClip(PlantSounds.class.getResource("./PlantSounds/cherrybomb.wav"));

}
