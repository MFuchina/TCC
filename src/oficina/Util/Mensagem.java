package oficina.Util;

import javax.swing.JOptionPane;

public class Mensagem {

    public static void msgErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void msgAviso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                "Alerta", JOptionPane.WARNING_MESSAGE);
    }

    public static void msgInfo(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean msgConf(String mensagem) {
        return JOptionPane.showConfirmDialog(null, mensagem,
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
