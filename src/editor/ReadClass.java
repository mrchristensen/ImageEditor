package editor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadClass{

    public PPMImage processFile(File myFile) throws IOException {

        Scanner scanner = new Scanner(myFile);
        scanner.useDelimiter("((#[^\\n]*\\n)|(\\s+))+");

        String magicNumber = scanner.next(); //P3
        int width = Integer.parseInt(scanner.next()); //How many pixels wide
        int height = Integer.parseInt(scanner.next()); //How many pixels tall
        int maxColor = Integer.parseInt(scanner.next()); //255

        System.out.println(magicNumber + width + height + maxColor);

        PPMImage myImage = new PPMImage(magicNumber, width, height, maxColor); //Create a new PPM object with the right width and everything

        int pixels = width * height * 3;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int r = Integer.parseInt(scanner.next());
                int g = Integer.parseInt(scanner.next());
                int b = Integer.parseInt(scanner.next());
                myImage.pixels[j][i] = new Pixel(r,g,b);
            }
        }

        return myImage;
    }
}
