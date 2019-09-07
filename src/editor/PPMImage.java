package editor;

class PPMImage {
    private String pValue;
    int width;
    int height;
    int maxColor;
    Pixel[][] pixels;

    PPMImage(String magicNumber, int w, int h, int max) {
        this.pValue = magicNumber;
        this.width = w;
        this.height = h;
        this.maxColor = max;
        pixels = new Pixel[w][h];
    }
}
