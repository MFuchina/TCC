package oficina;

import javax.swing.JFrame;
import oficina.telas.Principal;
import oficina.telas.PanelPrincipal;

public class Oficina {
    
    public static void main(String[] args) {
       //new teste().setVisible(true); 
        Principal frame = new Principal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PanelPrincipal(frame));
        frame.setSize(900, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
}
