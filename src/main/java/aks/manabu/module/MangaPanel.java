package aks.manabu.module;

public class MangaPanel {
    private String encodedImage;

    public MangaPanel(String encodedImage){
        this.encodedImage = encodedImage;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }
}
