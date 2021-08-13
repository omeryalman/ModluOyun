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




class Ates{
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

    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class HamburgerSavaslari extends JPanel implements KeyListener,ActionListener{
                   
    
    
    
    
    Timer timer = new Timer(5,this);
     
 private int gecen_sure;
 private BufferedImage image;
 private BufferedImage images;
 private BufferedImage hamburger;

 
private ArrayList<Ates> rakip_atesler = new ArrayList<Ates>();
 private ArrayList<Ates> atesler = new ArrayList<Ates>();
    
  
    
    private int atesdirY=1;
    private int topX=0;
    private int topdirX=2;
    private int asagiOyuncuX=0;
    private int dirUzayX=20;
           
  
    
    public boolean kontrolEt(){
        for (Ates ates : atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (topX,0,20,20))){
                return true;
                
            }
        }
        return false;
    }
    public boolean kontrolEt2(){
        for (Ates ates : rakip_atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (asagiOyuncuX,520,20,20))){
                return true;
                       

            }
        }
        return false;
                

    }
       
 
    public HamburgerSavaslari() {
          
        

     try {
         image=ImageIO.read(new FileImageInputStream(new File("images.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
      try {
         images=ImageIO.read(new FileImageInputStream(new File("rakip.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
     try {
         hamburger=ImageIO.read(new FileImageInputStream(new File("hamburger.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     
     
    setBackground(Color.lightGray);
    timer.start();
    }
      
    
    

        
       
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        gecen_sure+=5;
        g.setColor(Color.red);
        g.drawImage(images, topX, 0, images.getWidth()/3,images.getHeight()/3   , this);
        g.drawImage(image, asagiOyuncuX, 490, image.getWidth()/3,image.getHeight()/3   , this);
        
        timer.start();
        
        
        for(Ates ates : atesler){
            if(ates.getY()<0 ){
                atesler.remove(ates);
            }
                 

            
        }
        
        //buradan
        
        
        for(Ates ates : atesler){
            if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (topX,0,20,20)) ){
                        g.drawImage(images, topX, 0, images.getWidth()/2,images.getHeight()/2   , this);

            }
                 
            

            
        }
        
        
         for(Ates ates : rakip_atesler){
            if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (asagiOyuncuX,0,20,20)) ){
           g.drawImage(image, asagiOyuncuX, 0, image.getWidth()/2,image.getHeight()/2   , this);

            }
                 
           

            
        }
        
          //buraya şişmanlatma gelecek
        
        
     
         for(Ates ates : atesler){
            g.drawImage(hamburger,ates.getX(),ates.getY(),hamburger.getWidth()/6,hamburger.getHeight()/6, this);
            }
         for(Ates ates : rakip_atesler){
            g.drawImage(hamburger,ates.getX(),ates.getY(),hamburger.getWidth()/6,hamburger.getHeight()/6, this);
            }
         //     if(kontrolEt2()){//
       // timer.stop();
           //   String  message=" YEŞİL RAKİBİ YENDİNİZ " +
            //          "Geçen süre = " + gecen_sure/1000.0;
            //JOptionPane.showMessageDialog(this, message);
    //}
      //        if(kontrolEt()){
        //timer.stop();
          //    String  message="KIRMIZI RAKİBİ YENDİNİZ " +
            //          "Geçen süre = " + gecen_sure/1000.0;
           // JOptionPane.showMessageDialog(this, message);
    //}
     
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
            atesler.add(new Ates(asagiOyuncuX+5,470));
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
            rakip_atesler.add(new Ates(topX+5,20));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Ates ates : atesler ){
            ates.setY(ates.getY()-atesdirY);
        }
        for(Ates ates : rakip_atesler ){
            ates.setY(ates.getY()+atesdirY);
        }  
         
        repaint();
    }
       
     
           
 
    
}
