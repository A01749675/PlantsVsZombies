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
public class GameSounds {
    public static final AudioClip WIN = Applet.newAudioClip(PlantSounds.class.getResource("./GameSounds/winmusic.wav"));
    public static final AudioClip LOSE = Applet.newAudioClip(PlantSounds.class.getResource("./GameSounds/evillaugh.wav"));
    public static final AudioClip NEW_HORDE = Applet.newAudioClip(PlantSounds.class.getResource("./GameSounds/awooga.wav"));
    public static final AudioClip ROUND_START = Applet.newAudioClip(PlantSounds.class.getResource("./GameSounds/winmusic.wav"));

}
