package gov.iti.jets.server.repository.util;

public class ImageUtility {
    ImageUtility imageUtility = new ImageUtility();

    private ImageUtility(){

    }

    public ImageUtility getInstance(){
        return imageUtility;
    }

    public String readImageFromDisk(String image_path) {
        // read image from disk(path)
        // (String) encode image
        // return string encoded
        return null;
    }

    public boolean writeImageToDisk(String image_path, String encodedImage) {
        // decode image
        // write image to disk
        // return true/false;
        return true;
    }
}
