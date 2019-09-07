package editor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteClass {

    public void writeImage(String filename, PPMImage myImage) throws FileNotFoundException, IOException {
        String dataStream = "P3\n" + myImage.width + "\n" + myImage.height + "\n255\n";
        for (int i = 0; i < myImage.height; i++) {
            for (int j = 0; j < myImage.width; j++) {
                dataStream += "" + myImage.pixels[j][i].red + " " + myImage.pixels[j][i].green + " " + myImage.pixels[j][i].blue + "  ";
            }
            dataStream += "\n";
        }

        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(dataStream.getBytes());
        fos.close();

    }

}

