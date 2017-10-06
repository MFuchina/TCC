package oficina.Util;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
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

    public static boolean validaArea(JTextArea campo, String def) {
        if (campo.getText().trim().isEmpty()) {
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        } else if (campo.getText().trim().length() >= 80) {
            Mensagens.msgAviso("Você só pode digitar 80 caracteres no campo " + def + ".");
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
                int i = Integer.valueOf(aux);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
    }

    public static boolean validaCPF(String cpf) {
        //cpf = (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
        //Se um CPF conter todos os dígitos iguais, ele é inválido.
        if (cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999") || !cpf.matches("\\d{11}")) {
            Mensagens.msgErro("ERRO: CPF inválido (digite apenas 11 números).");
            return false;
        } else {
            int dv1 = calculaDVCpf(cpf, 8, 10);
            int dv2 = calculaDVCpf(cpf, 9, 11);
            String subs1 = cpf.substring(9, 10);
            String subs2 = cpf.substring(10, 11);
            String Dig1 = Integer.toString(dv1);
            String Dig2 = Integer.toString(dv2);
            if (subs1.equals(Dig1) && subs2.equals(Dig2)) {
                return true;
            } else {
                Mensagens.msgErro("ERRO: CPF inválido.");
                return false;
            }
        }
        /*for (int i = 0; i < cpf.length(); i++) {
                if (cpf.charAt(i) == '0' || cpf.charAt(i) == '1' || cpf.charAt(i) == '2' || cpf.charAt(i) == '3'
                        || cpf.charAt(i) == '4' || cpf.charAt(i) == '5' || cpf.charAt(i) == '6' || cpf.charAt(i) == '7'
                        || cpf.charAt(i) == '8' || cpf.charAt(i) == '9') {
                } else {
                    Mensagens.msgErro("ERRO: CPF inválido (apenas números).");
                    return false;
                }
            }*/
    }

//Calcula os dígitos verificadores do CPF informado.
    public static int calculaDVCpf(String cpf, int num, int peso) {
        int dv = 0;
        String parte;
        for (int i = 0; i <= num; i++) {
            parte = cpf.substring(i, i + 1);
            //Nesta parte, é aplicada a formula para se descobrir os DV's.
            dv = dv + (Integer.valueOf(parte) * (peso - i));
        }
        dv = 11 - (dv % 11);
        //Se o resultado de algum dos dois DV's for 10 ou 11, o DV é considerado como 0.
        if (dv == 11 || dv == 10) {
            dv = 0;
        }
        return dv;
    }

    public static int calculaDVCnpj(String cnpj, int num) {
        int dv = 0, peso = 2;
        String parte;
        for (int i = num; i >= 0; i--) {
            if (peso == 10) {
                peso = 2;
            }
            parte = cnpj.substring(i, i + 1);
            dv = dv + (Integer.valueOf(parte) * (peso));
            peso++;
        }
        dv = (dv % 11);
        if (dv == 0 || dv == 1) {
            dv = 0;
        } else {
            dv = (11-dv);
        }

        /*try {
            for (i = 11; i >= 0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0 
                // (48 eh a posição de '0' na tabela ASCII)
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dv = '0';
            } else {
                dv = ((11 - r) + 48);
            }
            return dv;
        } catch (InputMismatchException erro) {
            
        }*/
        return dv;
    }

    public static boolean validaCNPJ(String cnpj) {
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
                || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
                || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
                || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")
                || !cnpj.matches("\\d{14}")) {
            Mensagens.msgErro("ERRO: CNPJ inválido (digite apenas 14 números).");
            return false;
        } else {
            int dv1 = calculaDVCnpj(cnpj,11);
            int dv2 = calculaDVCnpj(cnpj,12);
            String subs1 = cnpj.substring(12, 13);
            String subs2 = cnpj.substring(13, 14);
            String Dig1 = Integer.toString(dv1);
            String Dig2 = Integer.toString(dv2);
            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if (subs1.equals(Dig1) && subs2.equals(Dig2)) {
                return true;
            } else {
                Mensagens.msgErro("ERRO: CNPJ inválido.");
                return false;
            }
        }
        /*if (!cnpj.matches("\\d{11}")) {
            System.out.println("ERRO: CNPJ inválido (digite apenas 11 números).");
            return false;
        } else {
            int dv1 = calculaDVCnpj(cnpj, 8, 10);
            int dv2 = calculaDVCnpj(cnpj, 9, 11);
            String subs1 = cnpj.substring(9, 10);
            String subs2 = cnpj.substring(10, 11);
            String Dig1 = Integer.toString(dv1);
            String Dig2 = Integer.toString(dv2);
            if (subs1.equals(Dig1) && subs2.equals(Dig2)) {
                return true;
            } else {
                Mensagens.msgErro("ERRO: CNPJ inválido.");
                return false;
            }
        }
        for (int i = 0; i < cnpj.length(); i++) {
                if (cnpj.charAt(i) == '0' || cnpj.charAt(i) == '1' || cnpj.charAt(i) == '2' || cnpj.charAt(i) == '3'
                        || cnpj.charAt(i) == '4' || cnpj.charAt(i) == '5' || cnpj.charAt(i) == '6' || cnpj.charAt(i) == '7'
                        || cnpj.charAt(i) == '8' || cnpj.charAt(i) == '9') {
                } else {
                    Mensagens.msgErro("ERRO: CNPJ inválido (apenas números).");
                    return false;
                }
            }*/
    }
}
