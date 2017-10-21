package oficina.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oficina.Util.Mensagens;

public class GerenteDAO {

    public boolean validaUsuario(String user, String senha) {
        boolean verifica = false;
        try {
            String aux = "jdbc:mysql://localhost:3306/oficina?"
                    + "user=root&password=root";
            Connection conexao;
            conexao = DriverManager.getConnection(aux);
            String sql = "select user, senha from gerente"
                    + " where user = ? "
                    + " and senha = ? ";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, user);
            p.setString(2, senha);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                verifica = true;
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Não foi possível realizar o login.");
        }
        return verifica;
    }

    public void verificaExecucao() {
        try {
            String aux = "jdbc:mysql://localhost:3306/oficina?"
                    + "user=root&password=root";
            Connection conexao;
            conexao = DriverManager.getConnection(aux);
            String sql = "select primeira_ex from gerente where primeira_ex = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, 0);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                Mensagens.msgInfo("O usuário padrão é 'admin' e a senha padrão é 'admin'.");
                alteraInt();
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao verificar se é a primeira execução do programa.");
        }
    }

    public void alteraInt() {
        try {
            String aux = "jdbc:mysql://localhost:3306/oficina?"
                    + "user=root&password=root";
            Connection conexao;
            conexao = DriverManager.getConnection(aux);
            String sql = "update gerente set primeira_ex = 1";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.execute();
            p.close();
            conexao.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro na alteração do banco de dados.");
        }
    }

    public boolean alteraLogin(String senha) {
        boolean verifica = false;
        try {
            String aux = "jdbc:mysql://localhost:3306/oficina?"
                    + "user=root&password=root";
            Connection conexao;
            conexao = DriverManager.getConnection(aux);
            String sql = "update gerente set senha= ? where user = 'admin'";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, senha);
            p.close();
            conexao.close();
            verifica = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Não foi possível realizar a alteração do login.");
        }
        return verifica;
    }
}
