package editor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadClass{
    public void processFile(File myFile) throws IOException {
        Scanner scanner = new Scanner(myFile);
        scanner.useDelimiter("((#[^\\n]*\\n)|(\\s+))+");
        while(scanner.hasNext()) {
            String str = scanner.next();
            // Do something with the String
        }
    }
}
