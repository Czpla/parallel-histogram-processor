package Helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;;

public class ReadFile {

    public static BufferedImage read(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Error reading image file " + path + " - " + e.getMessage());

            return null;
        }
    }    
}