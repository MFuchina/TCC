package oficina;

import javax.swing.JFrame;
import oficina.telas.Principal;

public class Oficina {
    
    public static void main(String[] args) {
       //new teste().setVisible(true); 
        Principal frame = new Principal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
