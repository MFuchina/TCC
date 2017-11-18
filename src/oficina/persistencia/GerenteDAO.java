package oficina.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oficina.modelo.EntradaDTO;
import oficina.util.Mensagens;

public class GerenteDAO {
    
    public boolean salvaEntrada(EntradaDTO e){
        boolean aux = false;
        try {
            String a = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conexao;
            conexao = DriverManager.getConnection(a);
            String sql = "insert into entrada (data_entrada, valor, tipo) values"
                    + " (?, ?, ?)";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, e.getData());
            p.setFloat(2, e.getValor());
            p.setString(3, e.getTipo());
            p.execute();
            p.close();
            aux = true;
            conexao.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Não foi possível salvar a entrada.");
        }
        return aux;
    }

    public ArrayList<EntradaDTO> puxaEntradasDia(String data){
        ArrayList<EntradaDTO> lista = new ArrayList<>();
        try {
            String a = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conexao;
            conexao = DriverManager.getConnection(a);
            String sql = "select cod_entrada, valor, tipo from entrada where data_entrada = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, data);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                EntradaDTO e = new EntradaDTO(rs.getInt(1), rs.getFloat(2), rs.getString(3), data);
                lista.add(e);
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Não foi possível puxar as entradas.");
        }
        return lista;
    }
    
    public boolean removeEntrada(int cod){
        boolean aux = false;
        try {
            String a = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conexao;
            conexao = DriverManager.getConnection(a);
            String sql = "delete from entrada where cod_entrada = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, cod);
            p.execute();
            p.close();
            aux = true;
            conexao.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Não foi possível salvar a entrada.");
        }
        return aux;
    }
    
    public boolean validaUsuario(String user, String senha) {
        boolean verifica = false;
        try {
            String aux = "jdbc:mysql://localhost:3307/oficina?"
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
            String aux = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conexao;
            conexao = DriverManager.getConnection(aux);
            String sql = "select primeira_ex from gerente where user = 'admin'";
            PreparedStatement p = conexao.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    Mensagens.msgInfo("O usuário padrão é 'admin' e a senha padrão é 'admin'.");
                    alteraInt();
                }
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
            String aux = "jdbc:mysql://localhost:3307/oficina?"
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
            String aux = "jdbc:mysql://localhost:3307/oficina?"
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
