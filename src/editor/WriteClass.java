package editor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteClass {

    public void writeImage(String filename, PPMImage myImage) throws FileNotFoundException, IOException {
        System.out.println("Begin gathering data into string");
        StringBuilder dataStream = new StringBuilder();
         dataStream.append("P3\n" + myImage.width + "\n" + myImage.height + "\n255\n");
        for (int i = 0; i < myImage.height; i++) {
            for (int j = 0; j < myImage.width; j++) {
                dataStream.append("" + myImage.pixels[j][i].red + " " + myImage.pixels[j][i].green + " " + myImage.pixels[j][i].blue + "  ");
            }
            dataStream.append("\n");
        }

        System.out.println("Begin a write on: " + filename);
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(dataStream.toString().getBytes());
        fos.close();
    }

}

