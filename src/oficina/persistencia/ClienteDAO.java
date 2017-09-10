package oficina.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oficina.Util.Mensagens;
import oficina.modelo.ClienteDTO;

public class ClienteDAO {

    public boolean cadastraCliente(ClienteDTO c) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conexao = DriverManager.getConnection(str);
            String sql = "insert into cliente (nome, CPF_CNPJ, email, telefone, sexo) values"
                    + " (?, ?, ?, ?, ?)";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, c.getNome());
            p.setString(2, c.getCPF_CNPJ());
            p.setString(3, c.getEmail());
            p.setString(4, c.getTelefone());
            p.setString(5, c.getSexo());
            p.execute();
            p.close();
            conexao.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao cadastrar o cliente no banco de dados.");
        }
        return aux;
    }

    public boolean alteraCliente(ClienteDTO c) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conexao = DriverManager.getConnection(str);
            String sql = "update cliente set nome = ?, CPF_CNPJ = ?, email = ?,"
                    + " telefone = ?, sexo = ? where cod_cliente = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, c.getNome());
            p.setString(2, c.getCPF_CNPJ());
            p.setString(3, c.getEmail());
            p.setString(4, c.getTelefone());
            p.setString(5, c.getSexo());
            p.setInt(6, c.getCodigo());
            p.execute();
            p.close();
            conexao.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar o cliente no banco de dados.");
            System.out.println(ex.getMessage());
        }
        return aux;
    }

    public boolean removeCliente(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conexao = DriverManager.getConnection(str);
            String sql = "delete from cliente where cod_cliente = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            p.close();
            conexao.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao remover o cliente do banco de dados.");
            System.out.println(ex.getMessage());
        }
        return aux;
    }

    public boolean verificaDispon(String cpf_cnpj, int cod) {
        boolean aux = false;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select cod_cliente from cliente"
                    + " where CPF_CNPJ = ?"
                    + " and cod_cliente <> ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, cpf_cnpj);
            p.setInt(2, cod);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                aux = true;
            }
            rs.close();
            p.close();
            conn.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao verificar a duplicidade de nomes do produto no banco de dados.");
        }
        return aux;
    }

    public ArrayList<ClienteDTO> carregaClientes() {
        ArrayList<ClienteDTO> listaClientes = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(str);
            String sql = "select cod_cliente, nome, email, sexo, CPF_CNPJ, telefone from cliente";
            PreparedStatement p = conexao.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cc = new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                listaClientes.add(cc);
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar a lista de clientes do banco de dados.");
        }
        return listaClientes;
    }

    public String retornaUltimoCodigo() {
        int cod = 0;
        String aux = "";
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT MAX(cod_cliente) FROM cliente";
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

    public ClienteDTO puxaCliente(int codigo) {
        ClienteDTO cliente = null;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(str);
            String sql = "select cod_cliente, nome, email, sexo, CPF_CNPJ, telefone from cliente where cod_cliente = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                cliente = new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao puxar os dados do cliente do banco de dados.");
        }
        return cliente;
    }

    /*public String retornaCodigo(int cpf){
        int cod = 0;
        String aux = "";
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT cod_cliente FROM cliente WHERE cpf_cnpj = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, cpf);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                cod = (rs.getInt(1));
            }
            aux = String.valueOf(cod);
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao verificar o contador no banco de dados.");
        }
        return aux;
    }*/
}
