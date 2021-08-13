
package modluoyun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.*;
import java.nio.charset.MalformedInputException;
import javax.swing.*;

class Atess{
    private int x;
    private int y;

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

    public Atess(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/**
 *
 * @author ASUS
 */
public class AskerSavaslari extends JPanel implements KeyListener,ActionListener {
      Timer timer = new Timer(5,this);
 private int gecen_sure;
 private BufferedImage image;
 private BufferedImage images;
 private BufferedImage hamburger;
 private BufferedImage mermi_asagi;
 private BufferedImage tas_kale;
 private BufferedImage fuze;
  private BufferedImage ters_fuze;
  private BufferedImage kan;
  private BufferedImage patlama;
 
private ArrayList<Atess> rakip_atesler = new ArrayList<Atess>();
private ArrayList<Atess> roket_rakip_atesler = new ArrayList<Atess>();
 private ArrayList<Atess> atesler = new ArrayList<Atess>();
 private ArrayList<Atess> roket_atesler = new ArrayList<Atess>();
    
  
    
    private int atesdirY=1;
    private int topX=0;
    private int topdirX=2;
    private int asagiOyuncuX=0;
    private int dirUzayX=20;
    private int tas_kaleX=0;

    AskerSavaslari(String asker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
           
  
    
    public boolean kontrolEt(){
        for (Atess ates : atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (topX,100,20,20))){
                
                return true;
                
            }
        }
        return false;
    }
     public boolean kontrolEt1(){
        for (Atess ates : roket_atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (tas_kaleX,50,505,20))){
                
                
                return true;
                
            }
        }
        return false;
    }
     public boolean kontrolEt3(){
        for (Atess ates : roket_rakip_atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (tas_kaleX,570,505,20))){
                return true;
                       

            }
        }
        return false;
                

    }
    
    
    public boolean kontrolEt2(){
        for (Atess ates : rakip_atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (asagiOyuncuX,520,20,20))){
                return true;
                       

            }
        }
        return false;
                

    }
       
 
    public AskerSavaslari() {
          
        
     
               

     try {
         image=ImageIO.read(new FileImageInputStream(new File("asker.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
      try {
         images=ImageIO.read(new FileImageInputStream(new File("rakipasker.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
     try {
         hamburger=ImageIO.read(new FileImageInputStream(new File("mermi_yukarı.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
     
      try {
         mermi_asagi=ImageIO.read(new FileImageInputStream(new File("mermi_asagi.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
      
      try {
         tas_kale=ImageIO.read(new FileImageInputStream(new File("gri.jpg")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
       try {
         fuze=ImageIO.read(new FileImageInputStream(new File("fuze.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
       try {
         ters_fuze=ImageIO.read(new FileImageInputStream(new File("ters_fuze.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
         try {
         kan=ImageIO.read(new FileImageInputStream(new File("kan.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
          try {
         patlama=ImageIO.read(new FileImageInputStream(new File("patlama.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
       
      
       
       
       
    setBackground(Color.gray);
    timer.start();
    }
      
    
    

        
       
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        gecen_sure+=5;
        g.setColor(Color.red);
        g.drawImage(images, topX, 100, images.getWidth()/7,images.getHeight()/7   , this);
        g.drawImage(image, asagiOyuncuX, 480, image.getWidth()/12,image.getHeight()/12   , this);
         g.drawImage(tas_kale, tas_kaleX, 590, tas_kale.getWidth()+505,tas_kale.getHeight()/3   , this);
         g.drawImage(tas_kale, tas_kaleX, 0, tas_kale.getWidth()+505,tas_kale.getHeight()/3   , this);
        timer.start();
        
        
        for(Atess ates : atesler){
            if(ates.getY()<0 ){
                atesler.remove(ates);
            }
                 

            
        }
         
        
         
        
     
        
         for(Atess ates : atesler){
            g.drawImage(hamburger,ates.getX(),ates.getY(),hamburger.getWidth()/24,hamburger.getHeight()/24, this);
             if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (topX,120,505,20))){
            g.drawImage(kan,ates.getX(),ates.getY(),kan.getWidth()/5,kan.getHeight()/5, this);

                
                
            }
            
            }
         
         for(Atess ates : roket_atesler){
            g.drawImage(fuze,ates.getX(),ates.getY(),fuze.getWidth()/15,fuze.getHeight()/15, this);
            
           if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (tas_kaleX,50,505,20))){
                g.drawImage(patlama,ates.getX(),ates.getY(), patlama.getWidth()/10,patlama.getHeight()/10   , this);
            }          
            }
         
           for(Atess ates : roket_rakip_atesler){
            g.drawImage(ters_fuze,ates.getX(),ates.getY(),ters_fuze.getWidth()/15,ters_fuze.getHeight()/15, this);
             if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (tas_kaleX,570,505,20))){
                g.drawImage(patlama,ates.getX(),ates.getY(), patlama.getWidth()/10,patlama.getHeight()/10   , this);
                       

            }
         }
         
         for(Atess ates : rakip_atesler){
            g.drawImage(mermi_asagi,ates.getX(),ates.getY(),mermi_asagi.getWidth()/24,mermi_asagi.getHeight()/24, this);
            if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (asagiOyuncuX,510,20,20)) ){
          g.drawImage(kan,ates.getX(),ates.getY(),kan.getWidth()/5,kan.getHeight()/5, this);

            }
            }
       
         
              if(kontrolEt2()){
                  
        timer.stop();
        
               String  message=" AŞAĞIDAKİ ASKERİ YENDİNİZ " +
                      "Geçen süre = " + gecen_sure/1000.0;
            JOptionPane.showMessageDialog(this, message);
            
    }
                 if(kontrolEt3()){
        
             //duvara çarptığında ne olsun
    }
              
              
              if(kontrolEt1()){
        
          //duvara çarptığında ne olsun
    }
            
              if(kontrolEt()){
        timer.stop();
              String  message="YUKARIDAKİ ASKERİ YENDİNİZ " +
                      "Geçen süre = " + gecen_sure/1000.0;
            JOptionPane.showMessageDialog(this, message);
    }
    
    }
    
    
    
    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
          int c= e.getKeyCode();
        if(c==KeyEvent.VK_LEFT){
            
            if(asagiOyuncuX<=0){
                asagiOyuncuX=0;
            }
            else{
                asagiOyuncuX-=dirUzayX;
            }
        }
        else if(c==KeyEvent.VK_RIGHT){
             if(asagiOyuncuX>=730){
                 asagiOyuncuX =730;
             }
             else{
                 asagiOyuncuX+=dirUzayX;
             }
        }
        else if(c==KeyEvent.VK_ENTER){
            atesler.add(new Atess(asagiOyuncuX+5,470));
        }
         else if(c==KeyEvent.VK_SPACE){
            roket_atesler.add(new Atess(asagiOyuncuX+5,470));
        }
        
        int d= e.getKeyCode();
        if(d==KeyEvent.VK_A){
            if(topX<=0){
                topX=0;
            }
            else{
                topX-=dirUzayX;
            }
        }
        else if(d==KeyEvent.VK_D){
             if(topX>=730){
                 topX =730;
             }
             else{
                 topX+=dirUzayX;
             }
        }
        else if(d==KeyEvent.VK_CONTROL){
            rakip_atesler.add(new Atess(topX+5,150));
        }
         else if(d==KeyEvent.VK_SHIFT){
            roket_rakip_atesler.add(new Atess(topX+5,150));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         for(Atess ates : atesler ){
            ates.setY(ates.getY()-atesdirY);
        }
          for(Atess ates : roket_atesler ){
            ates.setY(ates.getY()-atesdirY);
        }
        for(Atess ates : roket_rakip_atesler ){
            ates.setY(ates.getY()+atesdirY);
        }  
        for(Atess ates : rakip_atesler ){
            ates.setY(ates.getY()+atesdirY);
        }  
         
        repaint();
    }

    void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setResizable(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
    

