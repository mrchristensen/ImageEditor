package editor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImageEditor {

    public static void main(String args[]) throws IOException {
        //Args
        String inputFileName = args[0];
        String outputFileName = args[1];
        String transform = args[2];
        int blurLength = 0;
        if (transform.equals("motionblur")) { //If motion blur is the transform we need the amount
            blurLength = Integer.parseInt(args[3]);
        }

        //###
        for (int i = 0; i < args.length; i++) {
            String message = String.format("Argument %d is %s", i, args[i]);
            System.out.println(message);
        }

        File myFile = new File(inputFileName);

        if (!myFile.exists()) {
            System.out.println("File not created successfully");
        }
//        else {
//            usingFileWriter(myFile, outputFileName);
//        }

        PPMImage myImage = new ReadClass().processFile(myFile); //Read

        //Transform
        //Write
    }


    public static void usingFileWriter(File myFile, String outputFileName) throws IOException {
        FileWriter fileWriter = new FileWriter(outputFileName);
        fileWriter.write(String.valueOf(myFile));
        fileWriter.close();
    }

}