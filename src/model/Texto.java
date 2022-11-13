
package model;

/**
 *
 * @author Lucas Peccinin
 */
public class Texto {
    private String text;

    /**
     *
     * @param text
     */
    public Texto(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.text;
    }
    
}
