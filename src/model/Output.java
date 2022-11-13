package model;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class Output {

    /**
     *
     * @param path
     * @param text
     * @throws IOException
     */
    public static void outputFile(String path, List text) throws IOException {
        Writer writer;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("text.txt"), StandardCharsets.UTF_8));
            for (int i = 0; i <= text.size() - 1; i++) {
                String linha = text.get(i).toString();
                byte[] bytes = linha.getBytes("UTF-8");
                String conversao = new String(bytes, StandardCharsets.UTF_8);
                conversao = new String(conversao.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                writer.write(conversao);
                writer.write("\r\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
