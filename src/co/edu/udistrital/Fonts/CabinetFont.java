package co.edu.udistrital.Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CabinetFont {
    private static Font cabinetFont;

    public static Font getCabinetFont(float size) throws IOException, FontFormatException {
        File archivoFont = new File("src/co/edu/udistrital/Fonts/CabinetGrotesk-Variable.ttf");
        cabinetFont = Font.createFont(Font.TRUETYPE_FONT, archivoFont).deriveFont(size);
        return cabinetFont;
    }
}
