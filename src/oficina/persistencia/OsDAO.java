package oficina.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oficina.Util.Mensagens;
import oficina.modelo.OsDTO;

public class OsDAO {

    public boolean cadastraOS(OsDTO os) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into ordem_servico (cod_cliente, cod_moto, data_os, status_os, valorTotal_os) values"
                    + " (?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, os.getCod_cliente());
            p.setInt(2, os.getCod_moto());
            p.setDate(3, (Date) os.getData());
            p.setString(4, os.getStatusOS());
            p.setFloat(5, os.getTotal());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao cadastrar a ordem de serviço no banco de dados.");
        }
        return aux;
    }

    public boolean alteraOS(OsDTO os) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update ordem_servico set cod_cliente = ?, cod_moto = ?, status_os = ?"
                    + " where cod_os = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, os.getCod_cliente());
            p.setInt(2, os.getCod_moto());
            p.setString(3, os.getStatusOS());
            p.setInt(4, os.getCodOs());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar a ordem de serviço no banco de dados.");
        }
        return aux;
    }

    public boolean removeOS(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "delete from ordem_servico where COD_OS = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao remover a ordem de serviço do banco de dados.");
        }
        return aux;
    }

    public ArrayList<OsDTO> carregaOs() {
        ArrayList<OsDTO> listaOs = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select cod_os, cod_cliente, cod_moto, data_os, status_os, valorTotal_os from ordem_servico";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                OsDTO os = new OsDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getFloat(6));
                listaOs.add(os);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar as ordens de serviço do banco de dados.");
        }
        return listaOs;
    }

    public OsDTO puxaOs(int codigo) {
        OsDTO os = null;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(str);
            String sql = "select cod_os, cod_cliente, cod_moto, data_os, status_os, valorTotal_os from ordem_servico where cod_os = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                os = new OsDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getFloat(6));
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao puxar a ordem de serviço do banco de dados.");
        }
        return os;
    }

    public String retornaUltimoCodigo() {
        String aux = "";
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT MAX(cod_os) FROM ordem_servico";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                if (String.valueOf(rs.getInt(1)) == null) {
                    aux = "0";
                } else {
                    aux = String.valueOf(rs.getInt(1) + 1);
                }
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao verificar o contador no banco de dados.");
        }
        return aux;
    }
}
