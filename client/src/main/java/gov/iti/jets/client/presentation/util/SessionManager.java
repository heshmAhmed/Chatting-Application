package gov.iti.jets.client.presentation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class SessionManager {

    public static final SessionManager sessionManager = new SessionManager();

    private SessionManager(){}

    public static SessionManager getInstance(){return sessionManager;}

    public File createSession(){
        File file = new File("session.txt");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return file;
    }

    public String encryption(char[] chars){
        StringBuilder encryptedText = new StringBuilder();
        for(char c : chars){
            c+=5;
            encryptedText.append(c);
        }
        return encryptedText.toString();
    }

    public String[] decryption(String string){
       char[] chars = string.toCharArray();
       StringBuilder stringBuilder = new StringBuilder();
        for(char c : chars){
            c-=5;
            stringBuilder.append(c);
        }
        System.err.println(string);
        System.out.println(stringBuilder);
        String[] arr = stringBuilder.toString().split(":");
        return arr;
    }

    public String readSession(File file){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            FileInputStream fis = new FileInputStream(file);
            int i=0;
            while((i = fis.read()) != -1){
                stringBuilder.append((char)i);
            }
            fis.close();

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File not found");
        }

        return stringBuilder.toString();
    }

    public void endSession(File file){
        if(file.exists()){
            file.delete();
            System.out.println("Session finish");
        }
    }

    public void saveSession(File file , String phone , String password){
        try{
            FileWriter fw = new FileWriter(file);
            char[] charsPhone = phone.toCharArray();
            char[] charsPass = password.toCharArray();
            fw.write(encryption(charsPhone));
            fw.write("?");
            fw.write(encryption(charsPass));
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }


//    public static void main(String[] args) {
//        saveSession(createSession(),"kol");
//        System.out.println(decryption(readSession(createSession())));;
//        //String encryption = encryption(createSession());
//        //System.out.println(encryption);
//      //  decryption(encryption);
//       // System.out.println(decryption(encryption));
//        //System.out.println(decryption(encryption(createSession())));;
//       // endSession(createSession());
//    }
}
