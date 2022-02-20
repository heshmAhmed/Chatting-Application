package gov.iti.jets.server.services.util;

import gov.iti.jets.common.client.IClientCallback;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServerUtil {
    /*holds online users map and all its functions*/

    private static ServerUtil serverUtil = new ServerUtil();
    public Map<String, IClientCallback> onlineUsers = new ConcurrentHashMap<>();

    private ServerUtil(){

    }

    public static ServerUtil getInstance(){
        return serverUtil;
    }

    public void addUserToOnline(String phoneNumber, IClientCallback callback){
        onlineUsers.put(phoneNumber, callback);
        for (Map.Entry<String, IClientCallback> entry : onlineUsers.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public void removeUserFromOnline(String phoneNumber){
        onlineUsers.remove(phoneNumber);
    }
}
