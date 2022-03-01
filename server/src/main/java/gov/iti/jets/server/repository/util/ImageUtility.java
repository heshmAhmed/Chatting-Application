package gov.iti.jets.server.repository.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;


public class ImageUtility {
    private final static ImageUtility imageUtility = new ImageUtility();
    private final String folderPath = System.getProperty("user.dir") + "/userImages/";
    private ImageUtility(){}
    public static ImageUtility getInstance(){
        return imageUtility;
    }

    public String readImage(String imagePath)  {
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(folderPath + imagePath));
        } catch (IOException e) {
           // e.printStackTrace();
            System.out.println("image not found on disk");
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public boolean writeImageToDisk(String imagePath, String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        boolean written = false;
        try {
            File file = new File(folderPath + imagePath);
            FileUtils.writeByteArrayToFile(file, decodedBytes);
            written = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return written;
    }

    public String[] splitOverSpace(String encodedImage) {
        int i = 0;
        StringBuilder image = new StringBuilder();
        StringBuilder imagePath = new StringBuilder();
        while(encodedImage.charAt(i) != ' ') {
            imagePath.append(encodedImage.charAt(i));
            i++;
        }
        i++;
        while(i < encodedImage.length()) {
            image.append(encodedImage.charAt(i));
            i++;
        }
        return new String[]{imagePath.toString(), image.toString()};
    }
}
