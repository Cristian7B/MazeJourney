package co.edu.udistrital.Resources.Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CabinetFontExtraBold {
    private static Font cabinetFontExtraBold;

    public static Font getCabinetFontExtraBold(float size) throws IOException, FontFormatException {
        File archivoFont = new File("src/co/edu/udistrital/Resources/Fonts/Files/CabinetGrotesk-Extrabold.otf");
        cabinetFontExtraBold = Font.createFont(Font.TRUETYPE_FONT, archivoFont).deriveFont(size);
        return cabinetFontExtraBold;
    }
}
