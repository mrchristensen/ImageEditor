package editor;

import java.io.File;
import java.io.IOException;

public class ImageEditor {

    public static void main(String[] args) throws IOException {
        String inputFileName = args[0]; //Args
        String outputFileName = args[1];
        String transform = args[2];
        int blurLength = 0;
        //If motion blur is the transform we need the amount
        if (transform.equals("motionblur")) {
            blurLength = Integer.parseInt(args[3]);
        }

        for (int i = 0; i < args.length; i++) {
            String message = String.format("args[%d] = %s", i, args[i]);
            System.out.println(message);
        }

        File myFile = new File(inputFileName);

        if (!myFile.exists()) {
            System.out.println("File not created successfully");
        }

        PPMImage myImage = new ReadClass().processFile(myFile); //Read

        switch(transform) { //Transform
            case "grayscale":
                myImage = new Transformer().grayscale(myImage);
                break;
            case "invert":
                myImage = new Transformer().invert(myImage);
                break;
            case "emboss":
                myImage = new Transformer().emboss(myImage);
                break;
            case "motionblur":
                myImage = new Transformer().motionBlur(myImage, blurLength);
                break;
            default:
                System.out.println("Error: transform not recognized");
        }

        new WriteClass().writeImage(outputFileName, myImage); //Write
        System.out.println("Finished write");
    }

}