
package modluoyun;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author ASUS
 * 
 */

public class OyunEkrani extends JFrame {

    public OyunEkrani(String title) throws HeadlessException {
        super(title);
    }

   

    public static void main(String[] args) {
        OyunEkrani ekran = new OyunEkrani("Oyun");
        OyunEkrani asker_ekran = new OyunEkrani("Asker");
        OyunEkrani futbol_ekran = new OyunEkrani("Futbol");
        OyunEkrani menu = new OyunEkrani("Menu (HAZIRLAYAN: ÖMER YALMAN)");
        OyunEkrani viking_ekrann = new OyunEkrani("VİKİNG");
        OyunEkrani bilgi_ekran = new OyunEkrani("NASIL OYNANIR?");
        JButton button = new JButton();
        menu.setResizable(false);
        menu.setFocusable(false);

        JButton b = new JButton("NASIL OYNANIR?");
        JButton f = new JButton("FUTBOL SAVAŞLARI");
    //   JButton h = new JButton("HAMBURGER SAVAŞLARI");
        JButton a = new JButton("ASKER SAVAŞLARI");
         JButton v = new JButton("VİKİNG SAVAŞLARI");

      /*  h.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                ekran.setVisible(true);
            }
        });
*/
         b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                bilgi_ekran.setVisible(true);
            }
        });
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                futbol_ekran.setVisible(true);
            }
        });
        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                asker_ekran.setVisible(true);
            }
        });
         v.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                viking_ekrann.setVisible(true);
            }
        });
        
         JLabel bilgi_a=new JLabel("Asker Savaşları= 1.oyuncu 'CTRL' ile ateş 'SHIFT' ile f0ze atabilir 2. oyuncu 'ENTER' ile ateş edip 'SPACE' ile füze atabilir.");
         JLabel bilgi_f=new JLabel("Futbol Savaşları= 1.oyuncu 'CTRL' ile şut atabilir 2. oyuncu ise 'ENTER' ile atabilir topu kurtarmak için topun önüne geçmek yeterlidir.");
         JLabel bilgi_v=new JLabel("Viking Savaşları= 1.oyuncu 'CTRL' ile ateş edebilir 'Z' tuşu ile kalkanı kullanabilir 2. oyuncu ise 'ENTER' ile ateş edip 'K' tuşu ile kalkanı kullanabilir");
         JLabel bilgi_g=new JLabel("Hareket Etmek= 1. oyuncu 'A' ve 'D' tuşu ile  2. oyuncu ise yön tuşlarıyla sağ ve sol yapabilir.");
          

        f.setBounds(100, 100, 200, 30);
        a.setBounds(100, 150, 200, 30);
    //   h.setBounds(100, 250, 200, 30);
        v.setBounds(100, 50, 200, 30);
        b.setBounds(100, 200, 200, 30);
        
        menu.add(b);
        menu.add(v);
    //   menu.add(h);
        menu.add(a);
        menu.add(f);
        menu.setSize(400, 400);
        menu.setLayout(null);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ekran.setResizable(false);
        ekran.setFocusable(false);
        ekran.setSize(800, 600);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        futbol_ekran.setResizable(false);
        futbol_ekran.setFocusable(false);
        futbol_ekran.setSize(900, 700);
        futbol_ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        asker_ekran.setResizable(false);
        asker_ekran.setFocusable(false);
        asker_ekran.setSize(900, 700);
        asker_ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
         bilgi_ekran.setResizable(false);
        bilgi_ekran.setFocusable(false);
        bilgi_ekran.setSize(900, 300);
        bilgi_g.setSize(1000,70);
        bilgi_a.setSize(1000,140);
        bilgi_f.setSize(1000,200);
        bilgi_v.setSize(1000,300);
        bilgi_ekran.add(bilgi_g);
        bilgi_ekran.add(bilgi_a);
        bilgi_ekran.add(bilgi_f);
        bilgi_ekran.add(bilgi_v);    
        bilgi_ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        viking_ekrann.setResizable(false);
        viking_ekrann.setFocusable(false);
        viking_ekrann.setSize(800, 600);
        viking_ekrann.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
/*
        HamburgerSavaslari hamburger = new HamburgerSavaslari();
        hamburger.requestFocus();
        hamburger.addKeyListener(hamburger);
        hamburger.setFocusable(true);
        hamburger.setFocusTraversalKeysEnabled(false);
        ekran.add(hamburger);
*/
        AskerSavaslari asker = new AskerSavaslari();
        asker.requestFocus();
        asker.addKeyListener(asker);
        asker.setFocusable(true);
        asker.setFocusTraversalKeysEnabled(false);
        asker_ekran.add(asker);

        FutbolSavaslari futbol = new FutbolSavaslari();
        futbol.requestFocus();
        futbol.addKeyListener(futbol);
        futbol.setFocusable(true);
        futbol.setFocusTraversalKeysEnabled(false);
        futbol_ekran.add(futbol);
        
        
        VikingSavaslari viking = new VikingSavaslari();
        viking.requestFocus();
        viking.addKeyListener(viking);
        viking.setFocusable(true);
        viking.setFocusTraversalKeysEnabled(false);
        viking_ekrann.add(viking);
        
        
        
      menu.setVisible(true);

    }

}
