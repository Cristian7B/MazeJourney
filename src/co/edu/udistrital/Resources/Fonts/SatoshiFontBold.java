package co.edu.udistrital.Resources.Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SatoshiFontBold {
    private static Font satoshiFontBold;
     /**
     * Metodo encargado de transformar el archivo de texto plano en
     * una fuente utilizable por el programa.
     * 
     * Este metodo lanza un {@code IOException} si un archivo seleccionado
     * como fuente de texto no se encuentra.
     * Este metodo lanza un {@code FontFormatException} si el tipo de formato 
     * de la fuente de texto no es el correcto.
     * 
     * @throws IOException
     * @throws FontFormatException
     */
    public static Font getSatoshiFontBold(float size) throws IOException, FontFormatException {
        File archivoFont = new File("src/co/edu/udistrital/Resources/Fonts/Files/Satoshi-Bold.otf");
        satoshiFontBold = Font.createFont(Font.TRUETYPE_FONT, archivoFont).deriveFont(size);
        return satoshiFontBold;
    }
}
