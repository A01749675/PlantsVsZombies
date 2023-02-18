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
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class juego extends JPanel {
    // Constantes
    public final int FILAS = 6;
    public final int COLUMNAS = 11;
    static final int WIDTH = 1600;
    static final int HEIGHT = 950;
    public int coordX[] = {25, 125, 225,325,425,525,625,725,825,925,1025,1125};
    public int coordY[] = {25, 125, 225,325,425,525,625};
    
    public static int timer = 300;
    public static int army = 0;
    public static boolean control = false;
    public static boolean derrota = false;
    int currency = 50;
    
    public Plant[][] plants = new Plant[FILAS+1][COLUMNAS];
    public ArrayList<ArrayList<Zombie>> zombies = new ArrayList<>(FILAS);
    Board b = new Board(this);
    Controlador c = new Controlador(this);
    // variables
    BufferedImage image;
    BufferedImage image2;
    BufferedImage image3;
    int plant = 0;
    public static int difficulty = 0;
    int level = 0;
    
    public juego() {
        this.setBackground(Color.green);
        for(int i = 0; i < FILAS; i++) {
            zombies.add(new ArrayList<>());
 
        }
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            
            }
            @Override
            public void keyPressed(KeyEvent e) {
                c.KeyPressed(e);
        }
        });
        setFocusable(true);
        addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                c.MouseClicked(me);

            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
            
        });
        setFocusable(true);
        // TEMPORAL
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        b.paint(g2d);
        c.paint(g2d);
        timer--;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        // UPDATE (paint or remove) ZOMBIES
        
        updateZombies(g2d);
        
        // UPDATE (paint or remove) PLANTS
        updatePlants(g2d);
        
        // ZOMBIE TIENE UN 1% DE PROBABILIDAD GRUÑIR DESPUÉS DE CIERTO TIEMPO
        if(ThreadLocalRandom.current().nextInt(0,  100) + 1 == 1) {
            Zombie.gruñir();
        }
        //
        updateLevels(g2d);
        //
        updateCurrency(g2d);
    }
    
    public void updatePlants(Graphics2D g) {
        for(int i = 0; i < FILAS; i++) {
            for(int j = 0; j < COLUMNAS; j++) {
                Plant p = plants[i][j];
                if(p != null) {
                    if(p.isVisible()) {
                        p.paint(g);
                    } else {
                        plants[i][j] = null;
                    }
                }
            }
        }
    }
    
    public void updateLevels(Graphics2D g){
        switch(level){
            case 0:
                try{
                    image = ImageIO.read(getClass().getResource("BEGUN.png"));
                }catch(Exception e){
                    e.printStackTrace();
                }
                int tam = 0;
                for(int i = 0; i<6; i++){
                    g.drawImage(image, 1100,tam,100,100,null);
                    tam+=100;
                }
                break;
            case 1:
                try{
                    image = ImageIO.read(getClass().getResource("MID.png"));
                }catch(Exception e){
                    e.printStackTrace();
                }
                tam = 0;
                for(int i = 0; i<6; i++){
                    g.drawImage(image, 1100,tam,100,100,null);
                    tam+=100;
                }
                break;
            case 2:
                try{
                    image = ImageIO.read(getClass().getResource("THE ENDGAME.png"));
                }catch(Exception e){
                    e.printStackTrace();
                }
                tam = 0;
                for(int i = 0; i<6; i++){
                    g.drawImage(image, 1100,tam,100,100,null);
                    tam+=101;
                }
                g.drawImage(image, 1100,tam,100,100,null);
                break;
        }
    }
    public void updateCurrency(Graphics2D g){
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
        g.setColor(Color.yellow);
        g.drawString("SUNFlowers:"+String.valueOf(c.num_sun), 900, 700);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.setColor(Color.BLACK);
        g.drawString("Plant Selected:"+String.valueOf(c.plant), 100, 625);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString("LEVEL "+String.valueOf(army), 100, 670);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("TIME "+String.valueOf(timer), 100, 700);
    }
    
    public void updateZombies(Graphics2D g) {
        for(int i = 0; i < FILAS; i++) {
            for(int j = 0; j < zombies.get(i).size(); j++) {
                Zombie zb = zombies.get(i).get(j);
                if(zb.isVisible()) zb.paint(g);
                else zombies.get(i).remove(j);
            }
        } 
    }
    public void zombies_difficulty(){
        switch(difficulty){
            case 0:
                for(int i = 0; i<6;i++){
                    zombies.get(i).add(new Comun(this,i));
                    if(zombies.get(i).get(0).getX()<75){
                        derrota = true;
                    }
                }
                break;
            case 1:
                for(int i = 0; i<3;i++){
                    zombies.get(i).add(new Cubo(this,i));
                    if(zombies.get(i).get(0).getX()<75){
                        derrota = true;
                    }
                }
                for(int i = 3; i<6;i++){
                    zombies.get(i).add(new Cono(this,i));
                    if(zombies.get(i).get(0).getX()<75){
                        derrota = true;
                    }
                }
                break;
            case 2:
                for(int i = 3; i<6;i++){
                    zombies.get(i).add(new Periodico(this,i));
                    if(zombies.get(i).get(0).getX()<75){
                        derrota = true;
                    }
                }
                 for(int i = 0; i<3;i++){
                    zombies.get(i).add(new Football(this,i));
                    if(zombies.get(i).get(0).getX()<75){
                        derrota = true;
                    }
                }
                break;
            case 3:
                  for(int i = 0; i<6; i++){
                     if(zombies.get(i).get(0).getX()<75){
                     derrota = true;
            }
        }
               break;
        }

    }
    
    public void levels(){
        UIManager um = new UIManager();
        um.put("OptionPane.messageForeground", Color.red);
        um.put("Panel.background", Color.gray);
        String[] levels = {"It has Begun", "Midway Town", "The EndGame"};
        level = JOptionPane.showOptionDialog(null, "¿Qué nivel quiere jugar?", "\t\tVENGADORES",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,new ImageIcon(getClass().getResource("Title.png")),levels,"Google"); 
        switch(level){
            case 0:
                difficulty = 0;
                control = true;
                break; 
            case 1:
                difficulty = 1;
                control = true;
                break; 
            case 2: 
                difficulty = 2;
                control = true;
                break;
            default:
                difficulty = 2;
                control = true;
                break;  
        }
    }
    public void end(){
        GameSounds.WIN.play();
        JOptionPane.showMessageDialog(this, "VICTORIA", "PVZ", JOptionPane.YES_NO_OPTION, new ImageIcon(getClass().getResource("Title.png")));
        
    }
    public void te_comieron_los_sesos(){
        GameSounds.LOSE.play();
        JOptionPane.showMessageDialog(this, "TE HAN COMIDO LOS SESOS", "PVZ", JOptionPane.YES_NO_OPTION, new ImageIcon(getClass().getResource("Title.png")));
    }
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Plants vs Zombies");
        juego game = new juego();
        frame.add(game);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.levels();
        while (control) {
            game.repaint();
            Thread.sleep(100);
            if(derrota){
                game.te_comieron_los_sesos();
                control = false;
            }
            switch(army){
                case 0:
                    if(timer==200){
                       game.zombies_difficulty();
                    }
                    if(timer == 100){
                        game.zombies_difficulty();
                    }
                    if(timer == 50){
                        game.zombies_difficulty();
                    }
                    if(timer<=0){
                       timer = 400;
                       army++;
                       difficulty++;
                    }
                    break;
                case 1:
                    if(timer==350){
                        game.zombies_difficulty();
                    }
                    if(timer==300){
                        game.zombies_difficulty();
                    }
                    if(timer == 200){
                        game.zombies_difficulty();
                    }
                    if(timer == 100){
                        game.zombies_difficulty();
                    }
                    if(timer<=0){
                       timer = 450;
                       army++;
                       difficulty++;  
                    }
                    break;
                case 2:
                    if(timer==400){
                        game.zombies_difficulty();
                    }
                    if(timer == 300){
                        game.zombies_difficulty();
                    }
                    if(timer == 200){
                        game.zombies_difficulty();
                    }
                    if(timer == 100){
                        game.zombies_difficulty();
                        
                    }
                    if(timer<=0){
                        timer = 500;
                        army++;
                    }
                    break;
                case 3:
                    if(timer<0){
                        control = false;
                        game.end();
                    }
                    break;
            } 
        }
    }
    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
    
}
