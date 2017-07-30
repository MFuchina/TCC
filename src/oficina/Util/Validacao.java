package oficina.Util;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validacao {

    public static boolean validaTexto(JTextField campo) {
        if (campo.getText().trim().isEmpty()) {
            Mensagem.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validaSenha(JPasswordField campo) {
        if (String.copyValueOf(campo.getPassword()).trim().isEmpty()) {
            Mensagem.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validaInteiro(JTextField campo) {
        try {
            int valor = Integer.valueOf(campo.getText());
            return true;
        } catch (Exception e) {
            Mensagem.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
    }
}
