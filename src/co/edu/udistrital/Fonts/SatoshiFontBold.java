package co.edu.udistrital.Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SatoshiFontBold {
    private static Font satoshiFontBold;

    public static Font getSatoshiFontBold(float size) throws IOException, FontFormatException {
        File archivoFont = new File("src/co/edu/udistrital/Fonts/Satoshi-Bold.otf");
        satoshiFontBold = Font.createFont(Font.TRUETYPE_FONT, archivoFont).deriveFont(size);
        return satoshiFontBold;
    }
}
