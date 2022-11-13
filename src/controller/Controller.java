package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.DAO;
import model.Output;
import model.TextoDAO;

/**
 *
 * @author Antonio
 */
public class Controller {

    private static List text;
    private static TextoDAO td = new TextoDAO();
    private static DAO e = new DAO();
    
    /**
     *
     * @param d
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Controller (DAO d) throws SQLException, ClassNotFoundException{
        this.e = d;
        this.td = new TextoDAO(e);
    }
    
    /**
     *
     */
    public Controller(){
        
    }
    
    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void getText() throws ClassNotFoundException, SQLException {
        text = td.retrieveText();
    }

    /**
     *
     * @param textArea
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws UnsupportedEncodingException
     */
    public static void setText(JTextArea textArea) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        getText();

        for (int i = 0; i <= text.size() - 1; i++) {
            String linha = text.get(i).toString();
            byte[] bytes = linha.getBytes(StandardCharsets.UTF_8);
            String conversao = new String(bytes, StandardCharsets.UTF_8);
            conversao = new String(conversao.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            textArea.append(conversao);
            textArea.append("\n");
        }
    }

    /**
     *
     * @throws IOException
     */
    public void output() throws IOException {
        Path path = Paths.get("");
        String directory = path.toAbsolutePath().toString();
        Output.outputFile(directory, text);
        JOptionPane.showMessageDialog(null, "Your file.txt was saved in: " + directory);

    }
}
