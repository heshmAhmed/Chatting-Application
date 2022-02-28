package gov.iti.jets.client.presentation.util;

import org.alicebot.ab.*;

public class ChatBot {
    private static final ChatBot chatBot = new ChatBot();
    private static final boolean TRACE_MODE = false;
    static String botName = "super";

    public ChatBot() {

    }

    public static ChatBot getInstance() {
        return chatBot;
    }

    public String sendMsgToBots(String msg) {

        String resourcesPath = getResourcesPath();
        System.out.println(resourcesPath);
        Bot bot = new Bot("super", "target/classes/chatBots");
        Chat chatSession = new Chat(bot);
        String botResponse = chatSession.multisentenceRespond(msg);

        if (!botResponse.equals("I have no answer for that.")) {
            return "ChatBot: " + botResponse;
        }
        return " ChatBOT: Sorry .. I have no answer.";
    }

    private static String getResourcesPath() {
        String url = ChatBot.class.getResource("/chatBots").toString();
        String path = url.substring(60, url.length() - 1);
        System.out.println(path);
        return path;
    }

}