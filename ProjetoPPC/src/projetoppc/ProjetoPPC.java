package projetoppc;

import javax.swing.UIManager;
import view.CadastroPlanoDeEnsino;
import view.Principal;

public class ProjetoPPC {

    public static void main(String[] args) {
       try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch(Exception e){ 
    }
        Principal principal = new Principal();
        principal.setVisible(true);
    }
    
}
