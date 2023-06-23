package Helpers;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class CalculateChannelHistogram {
    
    public static int[] calculate(BufferedImage image, int channel) {
        int[] histogram = new int[256];
        int width = image.getWidth();
        int height = image.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color pixelColor = new Color(image.getRGB(i, j));
                int channelValue;
                switch (channel) {
                    case 0:
                        channelValue = pixelColor.getRed();
                        break;
                    case 1:
                        channelValue = pixelColor.getGreen();
                        break;
                    case 2:
                        channelValue = pixelColor.getBlue();
                        break;
                    default:
                        channelValue = 0;
                        break;
                }

                histogram[channelValue]++;
            }
        }

        return histogram;
    }
}