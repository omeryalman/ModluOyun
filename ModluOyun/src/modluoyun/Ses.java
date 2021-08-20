package modluoyun;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;


public class Ses {
    public void sesCal (String url){
        File file = new File(url);
		AudioInputStream audioStream = null;
            try {
                audioStream = AudioSystem.getAudioInputStream(file);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Ses.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ses.class.getName()).log(Level.SEVERE, null, ex);
            }
		Clip clip = null;
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Ses.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                clip.open(audioStream);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Ses.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ses.class.getName()).log(Level.SEVERE, null, ex);
            }
		
			
		
		clip.start();
		 
		
                
	}
    
    }


	


        

