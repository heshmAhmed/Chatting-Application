package gov.iti.jets.client.presentation.util;

import org.alicebot.ab.*;

import java.net.UnknownHostException;

public class ChatBot {
    private static final ChatBot chatBot = new ChatBot();
    private final Bot bot = new Bot("super", getBotPath());
    private static final boolean TRACE_MODE = false;

    public ChatBot() {}

    public static ChatBot getInstance() {
        return chatBot;
    }

    public String sendMsgToBots(String msg) {
        String response = "";
        Chat chatSession = new Chat(bot);
        String botResponse = chatSession.multisentenceRespond(msg);
//        if (!botResponse.equals("I have no answer for that."))
//                response = "ChatBot: " + botResponse;
//        else
//            response = " ChatBOT: Sorry .. I have no answer.";

        return "Chatbot: " +botResponse;
    }



    private static String getBotPath() {
        String botPath = ChatBot.class.getResource( "/chatBots" ).toString();
        botPath = botPath.substring( 0, botPath.length() - 1 ).replace( "file:/", "" );

        if (botPath.contains( "jar" )){
            botPath = System.getProperty( "user.dir" );
        }

        return botPath;
    }

//    private static String getResourcesPath() {
//        String url = ChatBot.class.getResource("/chatBots").toString();
//        String path = url.substring(60, url.length() - 1);
//        System.out.println(path);
//        return path;
//    }

}