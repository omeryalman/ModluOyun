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




class Top{
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

    public Top(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class FutbolSavaslari extends JPanel implements KeyListener,ActionListener{
                   
    Ses ses = new Ses();

 
 Timer timer = new Timer(5,this);
 private int gecen_sure;
 private BufferedImage image;
 private BufferedImage images;
 private BufferedImage top;
 private BufferedImage ters_kale;
 private BufferedImage kale;
 private BufferedImage gol;
 
private ArrayList<Top> rakip_atesler = new ArrayList<Top>();
 private ArrayList<Top> atesler = new ArrayList<Top>();
    
  
    
    private int atesdirY=1;
    private int topX=300;
    private int topdirX=2;
    private int asagiOyuncuX=300;
     private int kaleX=250;
     private int kaleY=250;
    private int dirUzayX=20;
           
  
    
    public boolean kontrolEt(){
        for (Top ates : atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (kaleY,0,350,75))){
                return true;
                
            }
        }
        return false;
    }
    public boolean kontrolEt2(){
        for (Top ates : rakip_atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (kaleX,580,350,75))){
                return true;
                       

            }
        }
        return false;
                

    }
       
 
    public FutbolSavaslari() {
          
        
     
               

     try {
         image=ImageIO.read(new FileImageInputStream(new File("kirmizi_takim.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
        
      try {
         images=ImageIO.read(new FileImageInputStream(new File("mavi_takim.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
        
     try {
         top=ImageIO.read(new FileImageInputStream(new File("top.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
        
       try {
         kale=ImageIO.read(new FileImageInputStream(new File("yesil_kale.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
     
       try {
         ters_kale=ImageIO.read(new FileImageInputStream(new File("yesil_kale_ters.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
        
     try {
         gol=ImageIO.read(new FileImageInputStream(new File("gol.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }    
   
    setBackground(Color.green);
    timer.start();
    }
      
    
    

        
       
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        gecen_sure+=5;
        g.setColor(Color.red);
        g.drawImage(images, topX, 80, images.getWidth()/3,images.getHeight()/3   , this);
        g.drawImage(image, asagiOyuncuX, 490, image.getWidth()/3,image.getHeight()/3   , this);
        g.drawImage(ters_kale, kaleX, 590, ters_kale.getWidth(),ters_kale.getHeight()/3   , this);
        g.drawImage(kale, kaleY, 0, kale.getWidth(),kale.getHeight()/3   , this);
         
        timer.start();
        
        for(Top ates : atesler){
            if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (topX,80,images.getWidth()/3,images.getHeight()/3))){
                atesler.remove(ates);
            }
                 

            
        }
        
        for(Top ates : rakip_atesler){
            if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (asagiOyuncuX,490,image.getWidth()/3,image.getHeight()/3))){
                rakip_atesler.remove(ates);
            }
        }
        
        
         for(Top ates : atesler){
            g.drawImage(top,ates.getX(),ates.getY(),top.getWidth()/20,top.getHeight()/20, this);
             if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (kaleY,5,350,75))){
                g.drawImage(gol,ates.getX(),ates.getY(), gol.getWidth()/10,gol.getHeight()/10   , this);
            }       
            }
        
         for(Top ates : rakip_atesler){
            g.drawImage(top,ates.getX(),ates.getY(),top.getWidth()/20,top.getHeight()/20, this);
             if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (kaleX,570,350,75))){
                g.drawImage(gol,ates.getX(),ates.getY(), gol.getWidth()/10,gol.getHeight()/10   , this);
            }      
            }
        
              if(kontrolEt2()){
                   ses.sesCal("gololunca.wav");
        timer.stop();
              String  message=" SARI TAKIM KAZANDI " +
                      "Geçen süre = " + gecen_sure/1000.0;
            JOptionPane.showMessageDialog(this, message);
    }
              if(kontrolEt()){
                  ses.sesCal("gololunca.wav");
        timer.stop();
              String  message="KIRMIZI IAKIM KAZANDI " +
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
            atesler.add(new Top(asagiOyuncuX+15,470));
            ses.sesCal("topsesi.wav");
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
            rakip_atesler.add(new Top(topX+5,150));
            ses.sesCal("topsesi.wav");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Top ates : atesler ){
            ates.setY(ates.getY()-atesdirY);
        }
        for(Top ates : rakip_atesler ){
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
    
           
 
    

