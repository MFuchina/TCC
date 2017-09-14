package oficina.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oficina.Util.Mensagens;
import oficina.modelo.ServicoDTO;

public class ServicoDAO {

    public boolean cadastraServico(ServicoDTO servico) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into servico (NOME_SERVICO, PRECO_SERVICO, DESCRICAO_SERVICO) values"
                    + " (?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, servico.getNome());
            p.setFloat(2, servico.getPreco());
            p.setString(3, servico.getDesc());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao cadastrar o serviço no banco de dados.");
        }
        return aux;
    }

    public boolean alteraProduto(ServicoDTO servico) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update servico set NOME_SERVICO = ?, PRECO_SERVICO = ?, DESCRICAO_SERVICO = ?"
                    + " where COD_SERVICO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, servico.getNome());
            p.setFloat(2, servico.getPreco());
            p.setString(3, servico.getDesc());
            p.setInt(4, servico.getCod());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar o serviço no banco de dados.");
        }
        return aux;
    }

    public boolean removeServico(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "delete from servico where COD_SERVICO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao remover o serviço do banco de dados.");
        }
        return aux;
    }

    public ServicoDTO puxaServico(int codigo) {
        ServicoDTO servico = null;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(str);
            String sql = "select nome_servico, preco_servico, descricao_servico from servico where cod_servico = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                servico = new ServicoDTO(codigo, rs.getString(1), rs.getFloat(2), rs.getString(3));
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao puxar os dados do serviço do banco de dados.");
        }
        return servico;
    }
    
    public boolean verificaNome(String nome, int cod) {
        boolean aux = false;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select NOME_SERVICO from servico where NOME_SERVICO = ?"
                    + " and COD_SERVICO <> ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nome);
            p.setInt(2, cod);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                aux = true;
            }
            rs.close();
            p.close();
            conn.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao verificar a duplicidade de nomes de serviço no banco de dados.");
        }
        return aux;
    }

    public ArrayList<ServicoDTO> carregaServicos() {
        ArrayList<ServicoDTO> listaServicos = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_SERVICO, NOME_SERVICO, PRECO_SERVICO, DESCRICAO_SERVICO from servico";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ServicoDTO ss = new ServicoDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
                listaServicos.add(ss);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os produtos do banco de dados.");
        }
        return listaServicos;
    }

    public String retornaUltimoCodigo() {
        int cod = 0;
        String aux = "";
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT MAX(cod_servico) FROM servico";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                if (String.valueOf(rs.getInt(1)) == null) {
                    cod = 0;
                } else {
                    cod = (rs.getInt(1) + 1);
                }
            }
            aux = String.valueOf(cod);
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao verificar o contador no banco de dados.");
        }
        return aux;
    }
}
