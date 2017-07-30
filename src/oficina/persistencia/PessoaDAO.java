package oficina.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oficina.modelo.GerenteDTO;

public class PessoaDAO {

    public boolean autenticaFuncionario(
            String user,
            String senha) throws SQLException {
        boolean aux = false;

        // definição da String de conexão
        String str = "jdbc:mysql://localhost/oficina?"
                + "user=root&password=root";
        // estabelecer a conexão...mysql-connector-java-5.1.42-bin.jar
        Connection conn = DriverManager.getConnection(str);
        String sql = "select user_gerente, senha_gerente from gerente"
                + " where user_gerente = ? "
                + "   and senha_gerente = ? ";
        // enviar o select para ser analisado pelo banco
        // de dados...
        PreparedStatement p = conn.prepareStatement(sql);
        // definir o valor de cada um dos parâmetros...
        p.setString(1, user);
        p.setString(2, senha);
        ResultSet rs = p.executeQuery();
        GerenteDTO func = null;
        if (rs.next()) {
            func.setUser(rs.getString(1));
            func.setSenha(rs.getString(2));
        }
        return aux;
    }
}
