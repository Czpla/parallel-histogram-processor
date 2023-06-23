package Controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Filter {

    public static BufferedImage createImageWhite() {
        int width = 300;
        int height = 200;

        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);

        Graphics2D graphic = image.createGraphics();
        
        graphic.setColor(Color.RED);
        graphic.fillRect(0, 0, width, height);
        graphic.dispose();

        return image;
    }

    public static BufferedImage grayScale(BufferedImage image) {
        BufferedImage imageGray = image;

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color cor = new Color(image.getRGB(i, j));
                    
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                int grey = (red + green + blue) / 3;

                Color colorGrey = new Color(grey, grey, grey);

                imageGray.setRGB(i, j, colorGrey.getRGB());
            }
        }

        return imageGray;
    }

    public static BufferedImage invertColors(BufferedImage image) {
        BufferedImage invertedImage = image;

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color cor = new Color(image.getRGB(i, j));
                    
                int red = 255 - cor.getRed();
                int green = 255 - cor.getGreen();
                int blue = 255- cor.getBlue();

                Color colorGrey = new Color(red, green, blue);

                invertedImage.setRGB(i, j, colorGrey.getRGB());
            }
        }

        return invertedImage;
    }


    public static BufferedImage binarization(BufferedImage image) {
        BufferedImage imageGrey = image;

        for (int i = 0; i < image.getWidth(); i++){
            for (int j = 0; j < image.getHeight(); j++) {
                Color cor = new Color(image.getRGB(i, j));
                    
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                int grey = (red + green + blue) / 3;

                int newColor;
                if (grey > 126) {
                    newColor = 255;
                } else {
                    newColor = 0;
                }

                Color novoPixel = new Color(newColor, newColor, newColor);

                imageGrey.setRGB(i, j, novoPixel.getRGB());
            }
        }

        return imageGrey;
    }

    public static int[] histogramRGB(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] histogram = new int[3];

        for (int i = 0; i < histogram.length; i++) {
            histogram[i] = 0;
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color colorPixel = new Color(image.getRGB(i, j));

                histogram[0] += colorPixel.getRed(); 
                histogram[1] += colorPixel.getGreen(); 
                histogram[2] += colorPixel.getBlue();
            }
        }

        return histogram;
    }
}