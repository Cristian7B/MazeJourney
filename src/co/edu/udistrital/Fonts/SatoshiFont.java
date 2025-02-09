package co.edu.udistrital.Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SatoshiFont {
    private static Font satoshiFont;
     /**
     * Metodo encargado de transformar el archivo de texto plano en
     * una fuente utilizable por el programa.
     * 
     * Este metodo lanza un {@code IOException} si un archivo seleccionado
     * como fuente de texto no se encuentra.
     * Este metodo lanza un {@code FontFormatException} si el tipo de formato 
     * de la fuente de texto no es el correcto.
     * @throws IOException
     * @throws FontFormatException
     */
    public static Font getSatoshiFont(float size) throws IOException, FontFormatException {
        File archivoFont = new File("src/co/edu/udistrital/Fonts/Satoshi-Medium.otf");
        satoshiFont = Font.createFont(Font.TRUETYPE_FONT, archivoFont).deriveFont(size);
        return satoshiFont;
    }
}
