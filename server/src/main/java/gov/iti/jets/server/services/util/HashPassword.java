package gov.iti.jets.server.services.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  class HashPassword {
    private final static HashPassword hashPassword=new HashPassword();

    private HashPassword() {
    }

    public static HashPassword getInstance() {
        return hashPassword;
    }

    public  String hashPassword(String password){
        byte[] encodedHash = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            encodedHash = digest.digest( password.getBytes(StandardCharsets.UTF_8));
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return encodedHash.toString();
    }
}
