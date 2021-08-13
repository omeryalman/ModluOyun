
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
        JButton button = new JButton();
        menu.setResizable(false);
        menu.setFocusable(false);

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

        f.setBounds(100, 100, 200, 30);
        a.setBounds(100, 150, 200, 30);
    //   h.setBounds(100, 200, 200, 30);
        v.setBounds(100, 50, 200, 30);
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
