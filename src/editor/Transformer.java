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
        for (int i = myImage.height - 1; i >= 0; i--) { //Starts are bottom right corner of the "pixel array"/image
            for (int j = myImage.width - 1; j >= 0; j--) {
                int v;

                if (j > 0 && i > 0) { //Pixels that have a top left neighbour
                    int redDiff = myImage.pixels[j][i].red - myImage.pixels[j - 1][i - 1].red;
                    int greenDiff = myImage.pixels[j][i].green - myImage.pixels[j - 1][i - 1].green;
                    int blueDiff = myImage.pixels[j][i].blue - myImage.pixels[j - 1][i - 1].blue;
                    int maxDifference = findMaxDiff(redDiff, greenDiff, blueDiff); //Find the absolute biggest difference between the three separate colors

                    v = maxDifference + 128;
                    if (v < 0) {
                        v = 0;
                    } else if (v > 255) {
                        v = 255;
                    }
                } else { //Pixels that don't have a top left neighbour
                    v = 128;
                }

                myImage.pixels[j][i].red = v;
                myImage.pixels[j][i].green = v;
                myImage.pixels[j][i].blue = v;

            }
        }
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

                while(hPos < myImage.width && hPos <= j+blurLength-1) { //Checks to make sure that we have more pixels to read and we haven't already hit our desired range
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

    private int findMaxDiff(int x, int y, int z) {
        if(Math.abs(x) == Math.abs(y) && Math.abs(y) == Math.abs(z)){ //If they are all the same then return the first (red) value
            return x;
        } else if(Math.abs(x) > Math.abs(y) && Math.abs(x) > Math.abs(z)) { //If x is biggest
            return x;
        } else if(Math.abs(y) > Math.abs(x) && Math.abs(y) > Math.abs(z)) { //If y is biggest
            return y;
        } else if(Math.abs(z) > Math.abs(x) && Math.abs(z) > Math.abs(y)){ //If z is biggest
            return z;
        } else if(Math.abs(x) > Math.abs(z) && Math.abs(y) > Math.abs(z)){ //If x and y are bigger than z, take x
            return x;
        } else if (Math.abs(x) > Math.abs(y) && Math.abs(z) > Math.abs(y)){ //If x and z are bigger than y, take x
            return x;
        } else if (Math.abs(y) > Math.abs(x) && Math.abs(z) > Math.abs(x)){ //If y and z are bigger than x, take y
            return y;
        } else{
            System.out.println("findMaxDiff function in incomplete in it's cases\nx: " + Math.abs(x) + ", y: " + Math.abs(y) + ", z: " + Math.abs(z));
            return -1;
        }

    }

}
