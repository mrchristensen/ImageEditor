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
        for (int i = 0; i < myImage.height; i++) {
            for (int j = 0; j < myImage.width; j++) {
                int numColorValues = 0;
                int totalRedValues = 0;
                int totalGreenValues = 0;
                int totalBlueValues = 0;
                int hPos = j;

                while(hPos < myImage.width & hPos <= j+blurLength-1) { //Checks to make sure that we have more pixels to read and we haven't already hit our desired range
                    numColorValues++;
                    totalRedValues += myImage.pixels[hPos][i].red;
                    totalGreenValues += myImage.pixels[hPos][i].green;
                    totalBlueValues += myImage.pixels[hPos][i].blue;
                    hPos++;
                }

                //Averages the pixels founds for each color
                myImage.pixels[j][i].red = (totalRedValues / numColorValues);
                myImage.pixels[j][i].green = (totalGreenValues / numColorValues);
                myImage.pixels[j][i].blue = (totalBlueValues / numColorValues);
            }
        }

        return myImage;
    }

}
