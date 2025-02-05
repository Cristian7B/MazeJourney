package co.edu.udistrital.Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SatoshiFont {
    private static Font satoshiFont;

    public static Font getSatoshiFont(float size) throws IOException, FontFormatException {
        File archivoFont = new File("src/co/edu/udistrital/Fonts/Satoshi-Medium.otf");
        satoshiFont = Font.createFont(Font.TRUETYPE_FONT, archivoFont).deriveFont(size);
        return satoshiFont;
    }
}
