package editor;

public class Transformer {

    public PPMImage grayscale(PPMImage myImage) {
        for (int i = 0; i < myImage.height; i++) {
            for (int j = 0; j < myImage.width; j++) {
                int grayscaleAverage = (myImage.pixels[j][i].red + myImage.pixels[j][i].green + myImage.pixels[j][i].blue) / 3;
                myImage.pixels[j][i].red = grayscaleAverage;
                myImage.pixels[j][i].green = grayscaleAverage;
                myImage.pixels[j][i].blue = grayscaleAverage;
            }
        }

        return myImage;
    }

    public PPMImage invert (PPMImage myImage) {
        for (int i = 0; i < myImage.height; i++) {
            for (int j = 0; j < myImage.width; j++) {
                myImage.pixels[j][i].red = myImage.maxColor - myImage.pixels[j][i].red;
                myImage.pixels[j][i].green = myImage.maxColor -myImage.pixels[j][i].green;
                myImage.pixels[j][i].blue = myImage.maxColor - myImage.pixels[j][i].blue;
            }
        }

        System.out.println("Done with Invert");
        return myImage;
    }

    public PPMImage emboss(PPMImage myImage) {
        return myImage;
    }

    public PPMImage motionBlur(PPMImage myImage, int blurLength) {
        return myImage;
    }
}
