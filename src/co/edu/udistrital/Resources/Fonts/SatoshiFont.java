package co.edu.udistrital.Resources.Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SatoshiFont {
    private static Font satoshiFont;

    public static Font getSatoshiFont(float size) throws IOException, FontFormatException {
        File archivoFont = new File("src/co/edu/udistrital/Resources/Fonts/Files/Satoshi-Medium.otf");
        satoshiFont = Font.createFont(Font.TRUETYPE_FONT, archivoFont).deriveFont(size);
        return satoshiFont;
    }
}
