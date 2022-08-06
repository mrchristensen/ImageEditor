package editor;

import java.io.FileOutputStream;
import java.io.IOException;

class WriteClass {

    void writeImage(String filename, PPMImage myImage) throws IOException {
        System.out.println("Begin gathering data into string");
        StringBuilder dataStream = new StringBuilder();
        dataStream.append("P3\n").append(myImage.width).append("\n").append(myImage.height).append("\n255\n");
        for (int i = 0; i < myImage.height; i++) {
            for (int j = 0; j < myImage.width; j++) {
                dataStream.append(myImage.pixels[j][i].red).append(" ").append(myImage.pixels[j][i].green).append(" ").append(myImage.pixels[j][i].blue).append("  ");
            }
            dataStream.append("\n");
        }

        System.out.println("Begin a write on: " + filename);
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(dataStream.toString().getBytes());
        fos.close();
    }

}

