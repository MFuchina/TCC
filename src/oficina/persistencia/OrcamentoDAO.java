package oficina.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oficina.Util.Mensagens;
import oficina.modelo.OrcamentoDTO;

public class OrcamentoDAO {

    public boolean cadastraOrcamento(OrcamentoDTO orcamento) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into orcamento (cod_cliente, cod_moto, data_orcamento, valorTotal_orcamento) values"
                    + " (?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, orcamento.getCod_cliente());
            p.setInt(2, orcamento.getCod_moto());
            p.setDate(3, (Date) orcamento.getData());
            p.setFloat(4, orcamento.getTotal());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao cadastrar o orçamento no banco de dados.");
        }
        return aux;
    }

    public boolean alteraOrcamento(OrcamentoDTO orcamento) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update orcamento set cod_cliente = ?, cod_moto = ?, valorTotal_orcamento = ?"
                    + " where cod_orcamento = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, orcamento.getCod_cliente());
            p.setInt(2, orcamento.getCod_moto());
            p.setFloat(3, orcamento.getTotal());
            p.setInt(4, orcamento.getCod_Orcamento());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar o orçamento no banco de dados.");
        }
        return aux;
    }

    public boolean removeOrcamento(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "delete from orcamento where COD_ORCAMENTO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao remover o orçamento do banco de dados.");
        }
        return aux;
    }

    public ArrayList<OrcamentoDTO> carregaOrcamento() {
        ArrayList<OrcamentoDTO> listaOrcamentos = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select cod_orcamento, cod_cliente, cod_moto, data_orcamento, valorTotal_orcamento from orcamento";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                OrcamentoDTO o = new OrcamentoDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getFloat(5));
                listaOrcamentos.add(o);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar o orçamento do banco de dados.");
        }
        return listaOrcamentos;
    }

    public OrcamentoDTO puxaOrcamento(int codigo) {
        OrcamentoDTO orcamento = null;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(str);
            String sql = "select cod_cliente, cod_moto, data_orcamento, valorTotal_orcamento from orcamento where cod_orcamento = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                orcamento = new OrcamentoDTO(codigo, rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getFloat(4));
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao puxar o orçamento do banco de dados.");
        }
        return orcamento;
    }
    
    public String retornaUltimoCodigo() {
        int cod = 0;
        String aux = "";
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT MAX(cod_orcamento) FROM orcamento";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                cod = (rs.getInt(1) + 1);
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