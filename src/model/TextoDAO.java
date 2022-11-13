package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Peccinin
 */
public class TextoDAO extends DAO {
    
    DAO e = new DAO();

    public TextoDAO() {
    }

    /**
     *
     * @param d
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public TextoDAO(DAO d) throws SQLException, ClassNotFoundException {
        this.e = d;
    }

    /**
     *
     * @param query
     * @return
     * @throws ClassNotFoundException
     */
    public List retrieve(String query) throws ClassNotFoundException {
        List<Texto> texto = new ArrayList();
        ResultSet rs = e.getResultSet(query);
        try {
            while (rs.next()) {
                texto.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return texto;
    }

    /**
     *
     * @return
     * @throws ClassNotFoundException
     */
    public List retrieveText() throws ClassNotFoundException {
        return this.retrieve("SELECT TEXT FROM Fragmentos WHERE GROUPID = 8 ORDER BY LINE ASC");
    }

    private Texto buildObject(ResultSet rs) {
        Texto texto = null;
        try {
            texto = new Texto(rs.getString("TEXT"));
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return texto;
    }
}
