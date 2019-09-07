package editor;

public class PPMImage {
    int width;
    int height;
    Pixel[][] pixels;

    PPMImage(int w, int h){
        this.width = w;
        this.height = h;
        pixels = new Pixel[w][h];
    }
}
