package oficina.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oficina.Util.Mensagens;
import oficina.modelo.MotoDTO;

public class MotoDAO {

    public boolean cadastraMoto(MotoDTO moto) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into moto (cod_dono, marca, modelo, chassi, placa, cor, ano_mod, ano_fabr) values"
                    + " (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, moto.getCod_dono());
            p.setString(2, moto.getMarca());
            p.setString(3, moto.getModelo());
            p.setString(4, moto.getChassi());
            p.setString(5, moto.getPlaca());
            p.setString(6, moto.getCor());
            p.setInt(7, moto.getAno_modelo());
            p.setInt(8, moto.getAno_Fabr());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao cadastrar a moto no banco de dados.");
        }
        return aux;
    }

    public boolean alteraMoto(MotoDTO moto) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update moto set cod_dono = ?, marca = ?, modelo = ?, chassi = ?, placa = ?, cor = ?, ano_mod = ?, ano_fabr = ?"
                    + " where cod_moto = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, moto.getCod_dono());
            p.setString(2, moto.getMarca());
            p.setString(3, moto.getModelo());
            p.setString(4, moto.getChassi());
            p.setString(5, moto.getPlaca());
            p.setString(6, moto.getCor());
            p.setInt(7, moto.getAno_modelo());
            p.setInt(8, moto.getAno_Fabr());
            p.setInt(9, moto.getCod_moto());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar a moto no banco de dados.");
        }
        return aux;
    }

    public ArrayList<MotoDTO> carregaMotos(int codigo) {
        ArrayList<MotoDTO> listaMotos = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select cod_moto, marca, modelo, chassi, placa, cor, ano_mod, ano_fabr from moto where cod_dono = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                MotoDTO moto = new MotoDTO(rs.getInt(1), codigo, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                listaMotos.add(moto);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar as motos do banco de dados.");
        }
        return listaMotos;
    }

    public MotoDTO puxaMoto(int codigo) {
        MotoDTO moto = null;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(str);
            String sql = "select cod_dono, marca, modelo, chassi, placa, cor, ano_mod, ano_fabr from moto where cod_moto = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                moto = new MotoDTO(codigo, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao puxar a moto do banco de dados.");
        }
        return moto;
    }
    
    public boolean verificaDispon(String placa, int cod) {
        boolean aux = false;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select cod_moto from moto"
                    + " where placa = ?"
                    + " and cod_moto <> ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, placa);
            p.setInt(2, cod);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                aux = true;
            }
            rs.close();
            p.close();
            conn.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao verificar a duplicidade de motos no banco de dados.");
        }
        return aux;
    }

    public boolean removeMoto(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "delete from moto where cod_moto = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao remover a moto do banco de dados.");
        }
        return aux;
    }

    public String retornaUltimoCodigo() {
        int cod = 0;
        String aux = "";
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT MAX(cod_moto) FROM moto";
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
