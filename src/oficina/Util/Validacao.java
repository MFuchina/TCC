package oficina.Util;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validacao {

    public static boolean validaCampo(JTextField campo, String def) {
        if (campo.getText().trim().isEmpty()) {
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        } else if (campo.getText().trim().length() >= 60) {
            Mensagens.msgAviso("Você só pode digitar 60 caracteres no campo " + def + ".");
            return false;
        }
        return true;
    }

    public static boolean validaSenha(JPasswordField campo) {
        if (String.copyValueOf(campo.getPassword()).trim().isEmpty()) {
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validaFloat(JTextField campo, int min, int max) {
        if (campo.getText().trim().isEmpty()) {
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
        try {
            float valor = Float.valueOf(campo.getText());
            if (valor <= min || valor >= max) {
                Mensagens.msgErro("Preço inválido.");
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            Mensagens.msgErro("Preço inválido.");
            campo.requestFocus();
            return false;
        }
    }

    public static boolean validaInteiro(JTextField campo) {
        try {
            String aux = String.valueOf(campo.getText());
            if (!aux.isEmpty()) {
                for (int i = 0; i <= aux.length(); i++) {
                    if (aux.charAt(i) != '0' || aux.charAt(i) != '1' || aux.charAt(i) != '2' || aux.charAt(i) != '3'
                            || aux.charAt(i) != '4' || aux.charAt(i) != '5' || aux.charAt(i) != '6' || aux.charAt(i) != '7'
                            || aux.charAt(i) != '8' || aux.charAt(i) != '9') {
                        Mensagens.msgErro("Digite apenas números inteiros.");
                        return false;
                    }
                }
                 return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
    }
}
