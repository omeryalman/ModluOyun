
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




class Ates_{
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

    public Ates_(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class VikingSavaslari extends JPanel implements KeyListener,ActionListener{
                   
    
    
    
    
    Timer timer = new Timer(5,this);
     
 private int gecen_sure;
 private BufferedImage image;
 private BufferedImage images;
 private BufferedImage balta;
 private BufferedImage mermi_asagi;
 private BufferedImage tas_kale;
 private BufferedImage fuze;
  private BufferedImage ters_fuze;
  
   private BufferedImage kalkan;
  

 
private ArrayList<Ates_> rakip_atesler = new ArrayList<Ates_>();
 private ArrayList<Ates_> atesler = new ArrayList<Ates_>();
    
  
    
    private int atesdirY=1;
    private int topX=0;
    private int topdirX=2;
    private int asagiOyuncuX=0;
    private int dirUzayX=20;
           
  
    
    public boolean kontrolEt(){
        for (Ates_ ates : atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (topX,0,80,20))){
                return true;
                
            }
        }
        return false;
    }
    public boolean kontrolEt2(){
        for (Ates_ ates : rakip_atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (asagiOyuncuX,420,80,20))){
                return true;
                       

            }
        }
        return false;
                

    }
       
 
    public VikingSavaslari() {
          
        
    

     try {
         image=ImageIO.read(new FileImageInputStream(new File("viking.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
      try {
         images=ImageIO.read(new FileImageInputStream(new File("rakip_viking.png")));
     } catch (IOException ex) {
         Logger.getLogger(HamburgerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
    
      try {
         balta=ImageIO.read(new FileImageInputStream(new File("balta.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
     
      try {
         mermi_asagi=ImageIO.read(new FileImageInputStream(new File("asagi_bicak.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }
 try {
         kalkan=ImageIO.read(new FileImageInputStream(new File("kalkan.png")));
     } catch (IOException ex) {
         Logger.getLogger(AskerSavaslari.class.getName()).log(Level.SEVERE, null, ex);
     }      
     
     
     
    setBackground(Color.darkGray);
    timer.start();
    }
      
    
    

        
       
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        gecen_sure+=5;
        g.setColor(Color.red);
        g.drawImage(images, topX, 0, images.getWidth()/10,images.getHeight()/10   , this);
        g.drawImage(image, asagiOyuncuX, 440, image.getWidth()/7,image.getHeight()/7   , this);
        
        timer.start();
        
        
       
                
                    
                      
            

         

       
           
            for(Ates_ ates : atesler){
            if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (topX,70,80,20)) ){
                      g.drawImage(kalkan, topX-80, -25, kalkan.getWidth()/6,kalkan.getHeight()/6   , this);


            }
                 
            

            
        }
        
        
         for(Ates_ ates : rakip_atesler){
            if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (asagiOyuncuX,380,80,20)) ){
            g.drawImage(kalkan, asagiOyuncuX-50, 400, kalkan.getWidth()/6,kalkan.getHeight()/6   , this);
            }
                 
           

            
        }
        
         
          
          
       

       
     
         for(Ates_ ates : atesler){
            g.drawImage(balta,ates.getX(),ates.getY(),balta.getWidth()/20,balta.getHeight()/20, this);
            }
         for(Ates_ ates : rakip_atesler){
            g.drawImage(mermi_asagi,ates.getX(),ates.getY(),balta.getWidth()/16,balta.getHeight()/16, this);
            }
         
        
            if(kontrolEt2()){//
        timer.stop();
              String  message=" AŞAĞIDAKİ RAKİBİ YENDİNİZ " +
                     "Geçen süre = " + gecen_sure/1000.0;
            JOptionPane.showMessageDialog(this, message);
    }
              if(kontrolEt()){
        timer.stop();
              String  message="YUKARIDAKİ RAKİBİ YENDİNİZ " +
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
            atesler.add(new Ates_(asagiOyuncuX+45,470));
        }
       else if(c==KeyEvent.VK_K){
           for (Ates_ ates : rakip_atesler){
            if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (asagiOyuncuX,400,80,20))){
            rakip_atesler.remove(ates);
            }
            }
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
            rakip_atesler.add(new Ates_(topX-25,20));
        }
        else if(c==KeyEvent.VK_Z){
              for (Ates_ ates : atesler){
             if( new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle (topX,10,80,20))){
              atesler.remove(ates);
                
                       

            }
            }
                 
          //kalkan buraya
        }}
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Ates_ ates : atesler ){
            ates.setY(ates.getY()-atesdirY);
        }
        for(Ates_ ates : rakip_atesler ){
            ates.setY(ates.getY()+atesdirY);
        }  
         
        repaint();
    }
       
     //HAZIRLAYAN ÖMER YALMAN
           
 
    
}
