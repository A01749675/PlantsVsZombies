/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLZ;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 *
 * @author ikerf
 */
public class Controlador{
    private juego game;
    public Controlador(juego game){
        this.game = game; 
        
    }
    BufferedImage image;
    BufferedImage image2;
    BufferedImage image3;
    int plant = 0;
    int num_sun = 0;
    int sfx = 4;
    int sfy = 6;
    int psx = 5;
    int psy = 6;
    int nutx = 6;
    int nuty = 6;
    int pax = 7;
    int pay = 6;
    int chx = 8;
    int chy = 6;


    public void KeyPressed(KeyEvent e){
        //La selección de plantas se hace aquí. 
            if(e.getKeyCode() == KeyEvent.VK_1){
               plant = 1;
            }
            if(e.getKeyCode() == KeyEvent.VK_2){
                plant = 2;
            }
            if(e.getKeyCode() == KeyEvent.VK_3){
                plant = 3;
            }
            if(e.getKeyCode()==KeyEvent.VK_4){
                plant = 4;
            }
            if(e.getKeyCode()==KeyEvent.VK_5){
                plant = 5;
            } 
            switch(plant){
                //Con base en el valor asignado se itera sobre el objeto fantasma de planta y se alteran sus coordenadas
               case 1:                    
                    if(e.getKeyCode() == KeyEvent.VK_S){
                        if(sfy<game.FILAS){ 
                           sfy++;
                        }
                    }
                    if(e.getKeyCode() == KeyEvent.VK_W){
                        if(sfy>0){
                           sfy--;
                        }
                    }
                    if(e.getKeyCode() == KeyEvent.VK_A){
                        if(sfx>0){
                           sfx--;       
                        }
                    }
                    if(e.getKeyCode() == KeyEvent.VK_D){
                        if(sfx<game.COLUMNAS){
                           sfx++;        
                        }
                    }
                    //Este rubro checa si no hay plantas en el lugar, y si la condición se cumple, la planta y regresa a fantasma a su coordenada nicial. 
                    if(e.getKeyCode()== KeyEvent.VK_ENTER){
                        if(game.plants[sfy][sfx] == null){
                           game.plants[sfy][sfx] = new Sunflower(game, sfy , sfx);
                           num_sun ++;
                           sfx = 4;
                           sfy = 6;  
                        }
                    }
                    break;    
                case 2:     
                     if(e.getKeyCode() == KeyEvent.VK_S){
                         if(psy<game.FILAS){
                             psy++;
                         }
                     }
                     if(e.getKeyCode() == KeyEvent.VK_W){
                        if(psy>0){
                            psy--;
                        }
                     }
                     if(e.getKeyCode() == KeyEvent.VK_A){
                         if(psx>0){
                             psx--;
                         }
                     }
                     if(e.getKeyCode() == KeyEvent.VK_D){
                         if(psx<game.COLUMNAS){
                             psx++;
                         }
                     }
                    if(e.getKeyCode()== KeyEvent.VK_ENTER){
                        System.out.println(psy);
                       if(game.plants[psy][psx] == null){
                          game.plants[psy][psx] = new Peashooter(game,psy,psx); 
                          psx = 5;
                          psy = 6;
                       }
                    }
                    
                     break;
                case 3:
                     if(e.getKeyCode() == KeyEvent.VK_S){
                         if(nuty<game.FILAS){
                             nuty++;
                         } 
                     }
                     if(e.getKeyCode() == KeyEvent.VK_W){
                         if(nuty>0){
                             nuty--;
                         }
                     }
                     if(e.getKeyCode() == KeyEvent.VK_A){
                         if(nutx>0){
                             nutx--;
                         }
                     }
                     if(e.getKeyCode() == KeyEvent.VK_D){
                         if(nutx<game.COLUMNAS){
                             nutx++;
                         }
                     }
                    if(e.getKeyCode()== KeyEvent.VK_ENTER){
                       if(game.plants[nuty][nutx] == null){
                          game.plants[nuty][nutx] = new Wall_nut(game,nuty,nutx);
                          nutx = 6;
                          nuty = 6;
                       }    
                    }
                     break;
                case 4:
                    if(e.getKeyCode()==KeyEvent.VK_S){
                        if(pay<game.FILAS){
                            pay++;
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_W){
                        if(pay>0){
                            pay--;
                        }
                    }
                    if(e.getKeyCode()== KeyEvent.VK_A){
                        if(pax>0){
                            pax--;
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_D){
                        if(pax<game.COLUMNAS){
                            pax++;
                        }
                    }
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        if(game.plants[pay][pax] == null){
                           game.plants[pay][pax] = new Palaya(game,pay,pax);
                           pax = 7;
                           pay = 6;
                        }
                    }
                    break;
                case 5:
                    if(e.getKeyCode()==KeyEvent.VK_S){
                        if(chy<game.FILAS){
                            chy++;
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_W){
                        if(chy>0){
                            chy--;
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_A){
                        if(chx>0){
                            chx--;
                        }
                    }
                    if(e.getKeyCode()== KeyEvent.VK_D){
                        if(chx<game.COLUMNAS){
                            chx++;
                        }
                    }
                    if(e.getKeyCode()== KeyEvent.VK_ENTER){
                    if(game.plants[chy][chx] == null){
                        if(num_sun>=3){
                           game.plants[chy][chx] = new CherryBomb(game,chy,chx);
                           chx = 8;
                           chy = 6;
                           num_sun -=3;
                        }
                        if(num_sun<3){
                           chx = 8;
                           chy = 6;
                        }

                    }
                    }
                    break;
            }
    }
    public void MouseClicked(MouseEvent e){
        for(int i = 0; i<game.COLUMNAS;i++){
            for(int j = 0; i< game.FILAS;i++){
                if(game.plants[i][j]!=null){
                    System.out.println("FILTRO 1");
                    if(game.plants[i][j].TIPO_DE_PLANTA==1){
                        System.out.println("FILTRO 2");
                        if(e.getX()>=game.plants[i][j].getX() && e.getX()<=game.plants[i][j].getX()+50){
                            if(e.getY()>=game.plants[i][j].getY() && e.getX()<=game.plants[i][j].getY()+50){
                                Sunflower sf = (Sunflower) game.plants[i][j];
                                if(sf.isSkill()){
                                    game.setCurrency(game.getCurrency()+20);
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }
    public void MouseReleased(MouseEvent e){
    }
    public void paint(Graphics2D g){
        //El paint se encarga de actualizar las plantas fantasmas para dar la ilusión de movimiento. 
        Sunflower_ghost sf = new Sunflower_ghost(game,sfy,sfx);
        sf.paint(g);
        Peashooter_ghost ps = new Peashooter_ghost(game,psy,psx);
        ps.paint(g);
        Wall_nut_ghost nut = new Wall_nut_ghost(game,nuty,nutx);
        nut.paint(g);
        Palaya_ghost papaya = new Palaya_ghost(game,pay,pax);
        papaya.paint(g);
        CherryBomb_ghost ch = new CherryBomb_ghost(game,chy,chx);
        ch.paint(g);
          
    }
}
