package gov.iti.jets.server.services.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  class HashingFactory {
    private final static HashingFactory hashPassword=new HashingFactory();

    private HashingFactory() {
    }

    public static HashingFactory getInstance() {
        return hashPassword;
    }

    public String hashPassword(String password){
        byte[] encodedHash = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            encodedHash = digest.digest( password.getBytes(StandardCharsets.UTF_8));

            for ( byte unit: encodedHash) {
                stringBuilder.append(unit);
            }

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        System.out.println("Hashed ---->");
        return stringBuilder.toString();
    }
}
