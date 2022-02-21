//package gov.iti.jets.server.repository.util;
//
//import org.apache.commons.io.FileUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Base64;
//
//
//public class ImageUtility {
//    ImageUtility imageUtility = new ImageUtility();
//
//    private ImageUtility(){
//
//    }
//
//    public ImageUtility getInstance(){
//        return imageUtility;
//    }
//
//
//    public static String readImage( String filePath ) {
//        byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//        //return string encoded
//        return encodedString;
//    }
//
//
//    public static boolean writeImageToDisk(String image_path, String encodedString) throws IOException {
//
//        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//        FileUtils.writeByteArrayToFile(new File(image_path), decodedBytes);
//        return false;
//    }
//}
