package oficina.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oficina.util.Mensagens;
import oficina.modelo.ProdutoDTO;

public class ProdutoDAO {

    public boolean cadastraProduto(ProdutoDTO produto) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into produto (NOME_PDTO, MARCA_PDTO, PRECO_PDTO) values"
                    + " (?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, produto.getNome());
            p.setString(2, produto.getMarca());
            p.setFloat(3, produto.getPreco());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao cadastrar o produto no banco de dados.");
        }
        return aux;
    }

    public boolean alteraProduto(ProdutoDTO produto) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update produto set NOME_PDTO = ?, MARCA_PDTO = ?, PRECO_PDTO = ?"
                    + " where COD_PDTO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, produto.getNome());
            p.setString(2, produto.getMarca());
            p.setFloat(3, produto.getPreco());
            p.setInt(4, produto.getCod());
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar o produto no banco de dados.");
        }
        return aux;
    }

    public boolean removeProduto(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/oficina?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "delete from produto where COD_PDTO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao remover o produto do banco de dados.");
        }
        return aux;
    }

    public ProdutoDTO puxaProduto(int codigo) {
        ProdutoDTO produto = null;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(str);
            String sql = "select cod_pdto, nome_pdto, marca_pdto, preco_pdto from produto where cod_pdto = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                produto = new ProdutoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao puxar os dados do produto do banco de dados.");
        }
        return produto;
    }

    public boolean verificaNome(String nome, int codigo) {
        boolean aux = false;
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select NOME_PDTO from produto where NOME_PDTO = ?"
                    + " and COD_PDTO <> ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nome);
            p.setInt(2, codigo);
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

    public ArrayList<ProdutoDTO> carregaProdutos() {
        ArrayList<ProdutoDTO> listaPDTO = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_PDTO, NOME_PDTO, MARCA_PDTO, PRECO_PDTO from produto";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ProdutoDTO pp = new ProdutoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
                listaPDTO.add(pp);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os produtos do banco de dados.");
        }
        return listaPDTO;
    }

    public String retornaUltimoCodigo() {
        int cod = 0;
        String aux = "";
        String str = "jdbc:mysql://localhost:3307/oficina?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT MAX(cod_pdto) FROM produto";
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
