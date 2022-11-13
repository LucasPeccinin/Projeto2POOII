package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Peccinin
 */
public class DAO {   

    private static Connection con;
    private String usuario;
    private String senha;
    String url = "jdbc:mariadb://143.106.243.64:3306/SI400";

    /**
     *
     * @param usuario
     * @param senha
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Connection getConnection(String usuario, String senha) throws SQLException, ClassNotFoundException {
        String driver = "org.mariadb.jdbc.Driver";
        this.usuario = usuario;
        this.senha = senha;

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha!", "Falha!", 1);
            throw new RuntimeException("Erro de conexao", ex);
        }
    }

    /**
     *
     * @param query
     * @return
     * @throws ClassNotFoundException
     */
    protected ResultSet getResultSet(String query) throws ClassNotFoundException { //classe que permite consultar o retorno do banco de dados
        Statement st;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            st = (Statement) con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return rs;
    }
    
    /**
     *
     * @param queryStatement
     * @return
     * @throws SQLException
     */
    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    /**
     *
     * @throws ClassNotFoundException
     */
    public void terminar() throws ClassNotFoundException {
        try {
            DriverManager.getConnection(url, usuario, senha).close();
            JOptionPane.showMessageDialog(null, "Desconectado!", "Desconectado!", 1);
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
